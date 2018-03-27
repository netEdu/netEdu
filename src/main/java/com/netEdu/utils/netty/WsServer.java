package com.netEdu.utils.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class WsServer {

    private int port;

    public WsServer(int port) {
        this.port = port;
    }

    public void run()throws Exception{

        EventLoopGroup acceptor = new NioEventLoopGroup();
        EventLoopGroup worker = new NioEventLoopGroup();
        ServerBootstrap bootstrap = new ServerBootstrap();
        try {
            bootstrap.group(acceptor, worker);
            bootstrap.channel(NioServerSocketChannel.class);
            bootstrap.childHandler(new WsInitHandler());
            bootstrap.option(ChannelOption.SO_BACKLOG, 128);
            ChannelFuture f = bootstrap.bind(port).sync();
            f.channel().closeFuture().sync();
        }finally {
            acceptor.shutdownGracefully();
            worker.shutdownGracefully();
            System.out.println("服务器已关闭");
        }
    }


}
