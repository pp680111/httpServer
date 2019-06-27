package com.zst;

import com.zst.initializer.HttpServerInitializer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

public class Main {
    private final ServerBootstrap serverBootstrap;

    public Main(){
        serverBootstrap = new ServerBootstrap();
        NioEventLoopGroup group = new NioEventLoopGroup();
        serverBootstrap.group(group)
                .channel(NioServerSocketChannel.class)
                .childHandler(new HttpServerInitializer())
                .childOption(ChannelOption.SO_KEEPALIVE, true);
    }

    public static void main(String[] args){
        Main obj = new Main();
        obj.run();
    }

    public void run(){
        ChannelFuture channelFuture = serverBootstrap.bind(new InetSocketAddress(4396)).syncUninterruptibly();
        channelFuture.syncUninterruptibly();

    }
}
