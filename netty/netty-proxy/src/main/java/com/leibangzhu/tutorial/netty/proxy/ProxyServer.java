package com.leibangzhu.tutorial.netty.proxy;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;
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

//                        System.out.println("Received data");
//                        if (toRemoteHostChannelFuture.isDone()){
//                            System.out.println("Channel to localhost:9000 is done");
//                            toRemoteHostChannelFuture.channel().writeAndFlush("hello\n");
//                        }
                    }

                    @Override
                    public void channelActive(ChannelHandlerContext ctx) throws Exception {
                        //run000();
                        System.out.println("Server" + ctx.channel().remoteAddress() + "connected to Proxy Server");
                        Bootstrap bootstrap = new Bootstrap()
                                .group(ctx.channel().eventLoop())
                                .channel(NioSocketChannel.class)
                                .handler(new SimpleChatClientInitializer());

//                        bootstrap.group(new NioEventLoopGroup())
//                                .channel(NioSocketChannel.class)
//                                .handler(new SimpleChatClientInitializer());

//                        bootstrap.channel(NioSocketChannel.class).handler(
//                                new SimpleChannelInboundHandler<ByteBuf>() {
//                                    @Override
//                                    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) {
//                                        System.out.println("Received data" + msg.toString(Charset.defaultCharset()));
//                                    }
//                                });
                        //bootstrap.group(ctx.channel().eventLoop());
                        //bootstrap.group(new NioEventLoopGroup());

                        toRemoteHostChannelFuture = bootstrap.connect("127.0.0.1",9000);

                        //System.out.println("Connect to " + host + ":" + port);

                        Thread.sleep(5 * 1000);

                        // 向server发送消息
                        toRemoteHostChannelFuture.channel().writeAndFlush("hello" + System.lineSeparator());

                        //toRemoteHostChannelFuture = bootstrap.connect(new InetSocketAddress("localhost",9000));

//                        Thread.sleep(5 * 1000);
//
//                        if (toRemoteHostChannelFuture.isDone()){
//                            System.out.println("Channel to localhost:9000 is done");
//                            toRemoteHostChannelFuture.channel().writeAndFlush("hello\n");
//                        }
//
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

    public static void run000() throws Exception{
        EventLoopGroup group = new NioEventLoopGroup();

        try {
            Bootstrap bootstrap = new Bootstrap()
                    .group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new SimpleChatClientInitializer());

            Channel channel = bootstrap.connect("127.0.0.1",9000).sync().channel();

            System.out.println("Connect to " + "127.0.0.1" + ":" + "9000");

            Thread.sleep(10 * 1000);

            // 向server发送消息
            channel.writeAndFlush("hello" + System.lineSeparator());
            //channel.writeAndFlush("world" + System.lineSeparator());
            Thread.sleep(100 * 1000);

            //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//            while (true){
//                channel.writeAndFlush(in.readLine() + "\r\n");
//            }
        }finally {
            group.shutdownGracefully();
        }
    }

}
