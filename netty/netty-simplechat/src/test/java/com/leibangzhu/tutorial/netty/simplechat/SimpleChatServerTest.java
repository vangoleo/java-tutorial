package com.leibangzhu.tutorial.netty.simplechat;

import org.junit.Test;

public class SimpleChatServerTest {

    @Test
    public void test() throws Exception {
        SimpleChatServer server = new SimpleChatServer(9000);
        server.run();
        Thread.sleep(100 * 1000);
    }
}
