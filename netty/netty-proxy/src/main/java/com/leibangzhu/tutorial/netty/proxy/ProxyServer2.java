package com.leibangzhu.tutorial.netty.proxy;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.CharsetUtil;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

public class ProxyServer2 {

    private static Channel channel;

    public void bootstrap() {

        //创建 ServerBootstrap 以创建 ServerSocketChannel，并绑定它
        ServerBootstrap bootstrap = new ServerBootstrap();
        //设置 EventLoopGroup，其将提供用以处理 Channel 事件的 EventLoop
        bootstrap.group(new NioEventLoopGroup(), new NioEventLoopGroup())
                //指定要使用的 Channel 实现
                .channel(NioServerSocketChannel.class)
                //设置用于处理已被接受的子 Channel 的 I/O 和数据的 ChannelInboundHandler
                .childHandler(
                        new SimpleChannelInboundHandler<ByteBuf>() {
                            ChannelFuture connectFuture;
                            @Override
                            public void channelActive(ChannelHandlerContext ctx) throws Exception {

                                // 先保存echoClient到Proxy的channel
                                channel = ctx.channel();

                                //创建一个 Bootstrap 类的实例以连接到远程主机
                                Bootstrap bootstrap = new Bootstrap();
                                //指定 Channel 的实现
                                bootstrap.channel(NioSocketChannel.class).handler(
                                        //为入站 I/O 设置 ChannelInboundHandler
                                        new SimpleChannelInboundHandler<ByteBuf>() {
                                            @Override
                                            protected void channelRead0(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
                                                System.out.println("Received data:" + in.toString(Charset.defaultCharset()));

                                                in.retain();
                                                channel.writeAndFlush(in);
                                            }
                                        });
                                //使用与分配给已被接受的子Channel相同的EventLoop
                                System.out.println("使用与分配给已被接受的子Channel相同的EventLoop");
                                bootstrap.group(ctx.channel().eventLoop());
                                //bootstrap.group(new NioEventLoopGroup());
                                connectFuture = bootstrap.connect(
                                        //连接到远程节点
                                        new InetSocketAddress("127.0.0.1", 9000));
                            }

                            @Override
                            protected void channelRead0(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
                                System.out.println("Received data from chat client:" + byteBuf.toString(Charset.defaultCharset()));
                                if (connectFuture.isDone()) {
                                    //当连接完成时，执行一些数据操作（如代理）
                                    // do something with the data
                                    connectFuture.channel().writeAndFlush(Unpooled.copiedBuffer("Netty rocks!\n", CharsetUtil.UTF_8));
                                }
                            }
                        });
        //通过配置好的 ServerBootstrap 绑定该 ServerSocketChannel
        ChannelFuture future = bootstrap.bind(new InetSocketAddress(8000));
        future.addListener((ChannelFutureListener) channelFuture -> {
            if (channelFuture.isSuccess()) {
                System.out.println("Server bound");
            } else {
                System.err.println("Bind attempt failed");
                channelFuture.cause().printStackTrace();
            }
        });
    }
}
