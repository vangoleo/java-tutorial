//package com.leibangzhu.tutorial.netty.requestresponse;
//
//import io.netty.bootstrap.ServerBootstrap;
//import io.netty.channel.EventLoopGroup;
//import io.netty.channel.nio.NioEventLoopGroup;
//import io.netty.channel.socket.nio.NioServerSocketChannel;
//
//public class NettyServer {
//
//    public void run(){
//        EventLoopGroup bossGroup = new NioEventLoopGroup();
//        EventLoopGroup workGroup = new NioEventLoopGroup();
//
//        ServerBootstrap bootstrap = new ServerBootstrap()
//                .group(bossGroup,workGroup)
//                .channel(NioServerSocketChannel.class)
//                .childHandler()
//
//    }
//
//
//
//}
