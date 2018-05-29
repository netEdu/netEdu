package com.netEdu.utils.netty.service;

import com.netEdu.entity.Group;
import com.netEdu.utils.netty.Connection;
import com.netEdu.utils.netty.dao.GroupInjectMapper;
import io.netty.channel.Channel;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupInjectService {

    @Autowired GroupInjectMapper groupInjectMapper;

  public   void injectGroups(String id){
        System.out.println("开始重新载入分组。。。。。。");
        List<Group> groupList=groupInjectMapper.getAllGroup(id);
        System.out.println(groupList.size());
        if (groupList.size()>0){
            String gid="";
            Channel channel;
            for (Group group:groupList){
                //获取组id
                gid=group.getGroup_id()+"";
                //通过人员id获取channel
                channel= Connection.AllConnections.get(id);
                //检测是否存在讨论组,不存在则创建并添加链接，否则取出channelGroup并添加
                if(!Connection.chatGroup.containsKey(gid)){
                    System.out.println("分组不存在，正在创建分组。。。");
                    ChannelGroup channelGroup=new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
                    channelGroup.add(channel);
                    Connection.chatGroup.put(gid,channelGroup);
                    System.out.println("创建成功，组id为："+gid);

                }else {
                    System.out.println("分组存在，正在加入。。。");
                    ChannelGroup channelGroup=Connection.chatGroup.get(gid);
                    channelGroup.add(channel);
                    Connection.chatGroup.put(gid,channelGroup);
                    System.out.println("加入成功，组id为："+gid);
                }
            }
        }


    }


    public List<Group> checkAllGroup(String id){
        return groupInjectMapper.getAllGroup(id);
    }



}
