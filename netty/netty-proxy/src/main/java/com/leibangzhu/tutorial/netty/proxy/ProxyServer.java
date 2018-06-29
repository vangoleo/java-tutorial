package com.leibangzhu.tutorial.netty.proxy;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.nio.charset.Charset;

public class ProxyServer {
    private int localPort;         // 绑定的本地端口
    private String remoteHost;     // 连接到的远程主机
    private int remotePort;        // 连接到的远程端口

    public ProxyServer(int localPort, int remotePort, String remoteHost) {
        this.localPort = localPort;
        this.remoteHost = remoteHost;
        this.remotePort = remotePort;
    }

    public void run() {

        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workGroup = new NioEventLoopGroup();

        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(bossGroup, workGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new SimpleChannelInboundHandler<ByteBuf>() {

                    ChannelFuture toRemoteHostChannelFuture;     // 到远程Host主机的Future

                    @Override
                    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {

                        if (toRemoteHostChannelFuture.isDone()){
                            System.out.println("Channel to localhost:9000 is done");
                            toRemoteHostChannelFuture.channel().writeAndFlush(msg.toString(Charset.defaultCharset()) + "\n");
                        }
                    }

                    @Override
                    public void channelActive(ChannelHandlerContext ctx) throws Exception {
                        System.out.println("Server" + ctx.channel().remoteAddress() + "connected to Proxy Server");
                        Bootstrap bootstrap = new Bootstrap()
                                .group(ctx.channel().eventLoop())
                                .channel(NioSocketChannel.class)
                                .handler(new SimpleChatClientInitializer());

                        toRemoteHostChannelFuture = bootstrap.connect("127.0.0.1",9000);

                        Thread.sleep(5 * 1000);
                    }
                });

        ChannelFuture future = serverBootstrap.bind(localPort);
        future.addListener((ChannelFutureListener) future1 -> {
            if (future1.isSuccess()) {
                System.out.println("Server bound successfully");
            } else {
                System.out.println("Server bind failed.");
            }
        });
    }
}
