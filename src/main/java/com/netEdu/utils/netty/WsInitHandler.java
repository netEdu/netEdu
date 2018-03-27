package com.netEdu.utils.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;

public class WsInitHandler extends ChannelInitializer<SocketChannel> {
    private static final String WEBSOCKET_PATH = "/websocket";


    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        ChannelPipeline pipeline = channel.pipeline();
        pipeline.addLast("http-codec", new HttpServerCodec()); // Http消息编码解码
        pipeline.addLast("aggregator", new HttpObjectAggregator(65536)); // Http消息组装
        pipeline.addLast(new WebSocketServerProtocolHandler(WEBSOCKET_PATH, null, true));
        //pipeline.addLast("http-chunked", new ChunkedWriteHandler()); // WebSocket通信支持
        pipeline.addLast("handler", new WsServerHandler()); // WebSocket服务端Handler

    }
}
