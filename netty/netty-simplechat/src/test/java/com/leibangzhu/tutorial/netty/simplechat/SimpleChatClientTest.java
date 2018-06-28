package com.leibangzhu.tutorial.netty.simplechat;

import org.junit.Test;

public class SimpleChatClientTest {

    @Test
    public void test() throws Exception {
        SimpleChatClient client = new SimpleChatClient("127.0.0.1",9000);
        client.run();
        Thread.sleep(100 * 1000);
    }
}
