package com.leibangzhu.tutorial.netty.simplechat;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

public class SimpleChatClient {
    private String host;
    private int port;

    public SimpleChatClient(String host,int port){
        this.host = host;
        this.port = port;
    }

    public void run() throws Exception{
        EventLoopGroup group = new NioEventLoopGroup();

        try {
            Bootstrap bootstrap = new Bootstrap()
                    .group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new SimpleChatClientInitializer());

            Channel channel = bootstrap.connect(host,port).sync().channel();

            System.out.println("Connect to " + host + ":" + port);

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
