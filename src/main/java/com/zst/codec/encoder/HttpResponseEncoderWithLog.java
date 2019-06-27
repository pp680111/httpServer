package com.zst.codec.encoder;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.HttpResponseEncoder;

import java.util.List;

public class HttpResponseEncoderWithLog extends HttpResponseEncoder {
    @Override
    protected void encode(ChannelHandlerContext ctx, Object msg, List<Object> out) throws Exception {
        System.out.println("Ensure output");
        super.encode(ctx, msg, out);
    }
}
