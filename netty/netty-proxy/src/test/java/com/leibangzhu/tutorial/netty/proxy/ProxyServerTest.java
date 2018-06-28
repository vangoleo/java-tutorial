package com.leibangzhu.tutorial.netty.proxy;

import org.junit.Test;

public class ProxyServerTest {

    @Test
    public void test() throws Exception {
        ProxyServer server = new ProxyServer(9100,9000,"127.0.0.1");
        server.run();
        Thread.sleep(100 * 1000);
    }

    @Test
    public void test2() throws Exception {
        new BootstrapSharingEventLoopGroup().bootstrap();
        Thread.sleep(100 * 1000);
    }
}
