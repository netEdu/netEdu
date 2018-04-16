package com.netEdu.utils.netty;

import io.netty.channel.Channel;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Connection {
     public static final Map<String,Channel> AllConnections = new ConcurrentHashMap<String, Channel>();
   public static final  Map<String,ChannelGroup> chatGroup = new ConcurrentHashMap<String,ChannelGroup>();
     static final Map<String,ChannelGroup> classGroup = new ConcurrentHashMap<String,ChannelGroup>();
    public static final Map<String,String> ip_idMap = new ConcurrentHashMap<String,String>();






     public static void testBegin(String class_num,String paper_num){

         ChannelGroup cg=classGroup.get(class_num);
         for (Channel c:cg){
             c.writeAndFlush(new TextWebSocketFrame("2,"+paper_num));
         }


     }


     public static void transMessage(Channel ch,TextWebSocketFrame msg){
         String message=msg.text();
        String groupId = message.split(",")[1];
        if(chatGroup.containsKey(groupId)){
            SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String newMsg=message.replaceFirst(message.split("]")[0],message.split("]")[0]+","+
                    time.format(System.currentTimeMillis())+"]");

            for (Channel c:chatGroup.get(groupId)){
                if(ch!=c){
                    c.writeAndFlush(new TextWebSocketFrame(newMsg));
                }

            }

        }



     }


     public static void loginBind(Channel ch,TextWebSocketFrame msg){
         String id=msg.text().split(",")[1];
         String class_num=msg.text().split(",")[2];
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
         }else{
             System.out.println("检测到多开链接，正在关闭。。。");
             ch.close();

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
         if(AllConnections.containsKey(id)){
             AllConnections.remove(id);
         }
         if (ip_idMap.containsKey(ip)){
             ip_idMap.remove(ip);
         }

    }

}


