package com.netEdu.utils.netty;

import com.netEdu.entity.Group;
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

    void injectGroups(String id){
        System.out.println("开始重新载入分组。。。。。。");
        List<Group> groupList=groupInjectMapper.getAllGroup(id);
        if (groupList.size()>0){
            String gid="";
            Channel channel;
            for (Group group:groupList){
                //获取组id
                gid+=group.getGroup_id();
                //通过人员id获取channel
                channel=Connection.AllConnections.get(id);
                //检测是否存在讨论组,不存在则创建并添加链接，否则取出channelGroup并添加
                if(!Connection.chatGroup.containsKey(gid)){
                    ChannelGroup channelGroup=new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
                    channelGroup.add(channel);
                    Connection.chatGroup.put(gid,channelGroup);
                }else {
                    ChannelGroup channelGroup=Connection.chatGroup.get(gid);
                    channelGroup.add(channel);
                    Connection.chatGroup.put(gid,channelGroup);
                }
            }
        }


    }

}
