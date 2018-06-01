package com.netEdu.utils.netty;

import com.netEdu.entity.Group;
import com.netEdu.utils.netty.service.GroupInjectService;
import io.netty.channel.Channel;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class Connection {
    public static final Map<String,Channel> AllConnections = new ConcurrentHashMap<String, Channel>();
    public static final  Map<String,ChannelGroup> chatGroup = new ConcurrentHashMap<String,ChannelGroup>();
    static final Map<String,ChannelGroup> classGroup = new ConcurrentHashMap<String,ChannelGroup>();
    public static final Map<String,String> ip_idMap = new ConcurrentHashMap<String,String>();
    public static final Map<String,String>  class_teacher =new ConcurrentHashMap<String,String>();
    @Autowired
     GroupInjectService groupInjectService;

    public static Connection connection;


    public static void askClass(TextWebSocketFrame msg){

        String message = msg.text();
        String class_id=message.split(",")[1];
        Channel channel=null;
        if(class_teacher.containsKey(class_id)){
            if(AllConnections.containsKey(class_teacher.get(class_id))){
                channel=AllConnections.get(class_teacher.get(class_id));
                channel.writeAndFlush(new TextWebSocketFrame(message.split(",")[2]));
            }
        }
    }

    public static void addTeacherInClass(Channel ch,TextWebSocketFrame msg){
        String[] message=msg.text().split(",");
        String teacherId= message[1];
        String classId = message[2];
        if (!class_teacher.containsKey(classId)){
            class_teacher.put(classId,teacherId);
            if (classGroup.containsKey(classId)){
                ChannelGroup group=classGroup.get(classId);
                if(!group.contains(ch)){
                    group.add(ch);
                }
            }else{
                ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
                channelGroup.add(ch);
                classGroup.put(classId,channelGroup);
            }
        }

    }


    public static void classMessage(Channel ch,TextWebSocketFrame msg){
        String message = msg.text();
        String classId = message.split(",")[1];
        if(classGroup.containsKey(classId)){
            String newMsg=message.replaceFirst(message.split("]")[0],message.split("]")[0]+","+
                    System.currentTimeMillis());
            String newMsg1= newMsg.replaceFirst(","+classId,"");
            System.out.println(newMsg1);
            for (Channel c:classGroup.get(classId)){
                    c.writeAndFlush(new TextWebSocketFrame(newMsg1));
            }
        }
    }

    public static void warn(TextWebSocketFrame msg){
        String message=msg.text();
        String student_id=message.split(",")[1];
        Channel ch=AllConnections.get(student_id);
        ch.writeAndFlush(new TextWebSocketFrame("5"));
    }

    public static void studentRate(TextWebSocketFrame msg){
        String message=msg.text();
        String class_num=message.split(",")[1];
        ChannelGroup cg=classGroup.get(class_num);
        for (Channel c:cg){
            c.writeAndFlush(new TextWebSocketFrame("4"));
        }
    }


    public static  void teacherRate(TextWebSocketFrame msg){
        String message=msg.text();
        String teacher_id=message.split(",")[1];
        String class_num=message.split(",")[2];
        String questionId = message.split(",")[3];
        ChannelGroup cg=classGroup.get(class_num);
        for (Channel c:cg){
            c.writeAndFlush(new TextWebSocketFrame("3,"+teacher_id+","+questionId));
        }

    }


     public static void testBegin(TextWebSocketFrame msg){
        String message=msg.text();
        String class_num=message.split(",")[1];
        String paper_id=message.split(",")[2];
         ChannelGroup cg=classGroup.get(class_num);
         for (Channel c:cg){
             c.writeAndFlush(new TextWebSocketFrame("2,"+paper_id+","+System.currentTimeMillis()));
         }


     }


     public static void transMessage(Channel ch,TextWebSocketFrame msg){
         String message=msg.text();
        String groupId = message.split(",")[1];
        if(chatGroup.containsKey(groupId)){
            //SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String newMsg=message.replaceFirst(message.split("]")[0],message.split("]")[0]+","+
                    System.currentTimeMillis());
            System.out.println(newMsg+" "+chatGroup);
            for (Channel c:chatGroup.get(groupId)){

                    c.writeAndFlush(new TextWebSocketFrame(newMsg));


            }

        }



     }


     public  void loginBind(Channel ch,TextWebSocketFrame msg){
         //String id=msg.text().split(",")[1];
         //String class_num=msg.text().split(",")[2];
         String loginType=msg.text().split(":")[0].split(",")[1];
         //学生登录
         if ("Student".equals(loginType)){
             String id=msg.text().split(":")[1].split(",")[1];
             String class_num=msg.text().split(":")[1].split(",")[0];
             String ip=getIpAddress(ch);
             if (!ip_idMap.containsKey(ip)){
                 if(!AllConnections.containsKey(id)){
                     AllConnections.put(id,ch);
                     ip_idMap.put(ip,id);
                     if(classGroup.containsKey(class_num)){
                         ChannelGroup channelGroup=classGroup.get(class_num);
                         channelGroup.add(ch);
                         classGroup.put(class_num,channelGroup);
                     }else {
                         ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
                         channelGroup.add(ch);
                         classGroup.put(class_num, channelGroup);
                     }
                 }else {
                     AllConnections.remove(id);
                     AllConnections.put(id,ch);
                 }

                 System.out.println("本次操作的id是："+id);
                 System.out.println("ip地址为："+ip_idMap.get(ip));
                 connection.groupInjectService.injectGroups(id);
             }else{
                 System.out.println("检测到多开链接，正在关闭。。。");
                 ch.close();

             }
         }
         //教师登录
         if("Teacher".equals(loginType)){
             String id=msg.text().split(":")[1];
             String ip=getIpAddress(ch);
             if(!ip_idMap.containsKey(ip)){
                 if (!AllConnections.containsKey(id)){
                     AllConnections.put(id,ch);
                 }else{AllConnections.remove(id);
                        AllConnections.put(id,ch);
                 }
                 ip_idMap.put(ip,id);
                 System.out.println("本次操作的id是："+id);
                 System.out.println("ip地址为："+ip_idMap.get(ip));
                 connection.groupInjectService.injectGroups(id);
             }else {
                System.out.println("检测到多开链接，正在关闭。。。");
                ch.close();
             }
         }





     }


     public static int getMessageType(TextWebSocketFrame msg){
         String flag=msg.text().split("")[0];
         return Integer.parseInt(flag);
     }


    public static String getIpAddress(Channel ch) {
         String raw=ch.remoteAddress().toString();
         String[] firstSplit = raw.split(":");
         return firstSplit[0].substring(1);

     }

    public static void shutDown(Channel ch){
         String ip = getIpAddress(ch);
         String id = ip_idMap.get(ip);
         String classes="";
        List<Group> groups=connection.groupInjectService.checkAllGroup(id);
        if (groups.size()>0){//查看是否有加入的讨论组
            String gid;
            for (Group group:groups){//遍历加入的讨论组
                gid=group.getGroup_id()+"";
                if (chatGroup.containsKey(gid)){//若这个组已被激活则从中移除
                    Channel channel=AllConnections.get(id);
                    chatGroup.get(gid).remove(channel);
                }


            }
        }

        for(ConcurrentHashMap.Entry<String,ChannelGroup> entry:classGroup.entrySet()){
            //遍历map查看是否有加入班级中
            if (entry.getValue().contains(ch)){
                entry.getValue().remove(ch);
            }
        }

        //检查教师是否加入过班级
        for(ConcurrentHashMap.Entry<String,String> entry:class_teacher.entrySet()){
            //遍历map查看是否有加入班级中
            if (entry.getValue().equals(id)){
                classes+=entry.getKey()+",";
            }
        }
        String[] classesArray= classes.split(",");
        for (String cls:classesArray){
            if (class_teacher.containsKey(cls)){
                class_teacher.remove(cls);
            }
        }


         if(AllConnections.containsKey(id)){
             AllConnections.remove(id);
         }
         if (ip_idMap.containsKey(ip)){
             ip_idMap.remove(ip);
         }

    }
    @PostConstruct
    public void init() {
        connection = this;
        connection.groupInjectService = this.groupInjectService;
    }
}


