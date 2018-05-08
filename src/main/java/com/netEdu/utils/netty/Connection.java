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

    @Autowired
     GroupInjectService groupInjectService;

    public static Connection connection;


    public static void classMessage(Channel ch,TextWebSocketFrame msg){
        String message=msg.text();
        String classId = message.split(",")[1];
        if(classGroup.containsKey(classId)){
            //SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String newMsg=message.replaceFirst(message.split("]")[0],message.split("]")[0]+","+
                    System.currentTimeMillis()+"]");

            for (Channel c:classGroup.get(classId)){
                if(ch!=c){
                    c.writeAndFlush(new TextWebSocketFrame(newMsg));
                }

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
        ChannelGroup cg=classGroup.get(class_num);
        for (Channel c:cg){
            c.writeAndFlush(new TextWebSocketFrame("3,"+teacher_id));
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
         if (msg.text().equals("test")){
             return 12;
         }
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


