package com.zst.tools;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http.*;

import java.util.Map;

/**
 * 用来创建HttpResponse的工具类
 */
public class HttpResponseBuilder {
    public static FullHttpResponse httpResponseBuilder(Map<String, String> headers, ByteBuf content){
        FullHttpResponse fullHttpResponse = defaultHttpResponseBuilder(content);

        headers.forEach((key, value) -> { fullHttpResponse.headers().set(key, value); });

        return fullHttpResponse;
    }

    public static FullHttpResponse defaultHttpResponseBuilder(ByteBuf content){
        FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, content);
        response.headers().set("Content-Type","text/plain");
        response.headers().set("Content-Length", response.content().readableBytes());
        return response;
    }
}
