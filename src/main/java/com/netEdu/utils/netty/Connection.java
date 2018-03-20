package com.netEdu.utils.netty;

import io.netty.channel.Channel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Connection {
     static final Map<String,Channel> AllConnections= new ConcurrentHashMap<String, Channel>();

     public static String getIpAddress(Channel ch) {
         String raw=ch.remoteAddress().toString();
         String[] firstSplit = raw.split(":");
         return firstSplit[0].substring(1);

     }



}


