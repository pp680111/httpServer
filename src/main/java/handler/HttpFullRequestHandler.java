package handler;

import com.alibaba.fastjson.JSONObject;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

import java.util.Map;

public class HttpFullRequestHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        FullHttpRequest request = (FullHttpRequest)msg;
        FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, Unpooled.copiedBuffer("Hello World".getBytes(CharsetUtil.UTF_8)));
        response.headers().set("Content-Type","text/plain");
        response.headers().set("Content-Length", response.content().readableBytes());
        response.headers().set("Connection", HttpHeaderValues.KEEP_ALIVE);
        ctx.writeAndFlush(response);
    }
}
