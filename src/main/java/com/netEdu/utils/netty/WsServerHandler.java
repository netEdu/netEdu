package com.netEdu.utils.netty;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.util.Date;

@ChannelHandler.Sharable
public class WsServerHandler  extends SimpleChannelInboundHandler<TextWebSocketFrame> {
    Connection connection=new Connection();
    //public static final ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, TextWebSocketFrame msg) throws Exception {
        Channel incoming = channelHandlerContext.channel();
        //String ip=Connection.getIpAddress(incoming);
        System.out.println(Connection.getMessageType(msg));
        switch (Connection.getMessageType(msg)) {
            //当第一位为0时，接收学生ID，将ID和Channel一组存入Map,IP，ID一起存入MAP
            case 0:
                connection.loginBind(incoming, msg);
                break;
            //当第一位为1，转发消息
            case 1:
                Connection.transMessage(incoming,msg);
                break;
            //当第一位为2,开始考试
            case 2:
                Connection.testBegin(msg);
                break;
            //当第一位为3,教师评价
            case 3:
                Connection.teacherRate(msg);
                break;
            //当第一位为4,学生互评
            case 4:
                Connection.studentRate(msg);
                break;
            //当第一位为5,警♂告
            case 5:
                Connection.warn(msg);
                break;
            //当第一位为6,班级讨论组
            case 6:
                Connection.classMessage(incoming,msg);
                break;
        }



    }
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {  // (2)
//        Channel incoming = ctx.channel();
//        for (Channel channel : channels) {
//            channel.writeAndFlush(new TextWebSocketFrame("[SERVER] - " + incoming.remoteAddress() + " 加入"));
//        }
//        channels.add(ctx.channel());
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {  // (3)
//        Channel incoming = ctx.channel();
//        for (Channel channel : channels) {
//            channel.writeAndFlush(new TextWebSocketFrame("[SERVER] - " + incoming.remoteAddress() + " 离开"));
//        }
//        channels.remove(ctx.channel());
    }
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception { // (5)
//        Channel incoming = ctx.channel();
//        String ip=Connection.getIpAddress(incoming);
//        channels.add(incoming);
//        if(!Connection.AllConnections.containsKey(ip)){
//            Connection.AllConnections.put(ip,incoming);
//            System.out.println("Client:"+incoming.remoteAddress()+"在线");
//        }else {
//            System.out.println("检测到多开链接！正在关闭...");
//            incoming.close();
//        }


    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception { // (6)
       Connection.shutDown(ctx.channel());

    }
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        Channel incoming = ctx.channel();
        System.out.println("Client:"+incoming.remoteAddress()+"异常");
        // 当出现异常就关闭连接
        cause.printStackTrace();
        ctx.close();
    }

}

