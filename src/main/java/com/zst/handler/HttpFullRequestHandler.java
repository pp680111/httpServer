package com.zst.handler;

import com.zst.tools.HttpResponseBuilder;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.*;

public class HttpFullRequestHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        FullHttpRequest request = (FullHttpRequest)msg;

        ctx.writeAndFlush(HttpResponseBuilder.defaultHttpResponseBuilder(Unpooled.copiedBuffer(request.content())));
    }
}
