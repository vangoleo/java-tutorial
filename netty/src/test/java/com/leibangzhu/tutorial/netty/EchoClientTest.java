package com.leibangzhu.tutorial.netty;

import org.junit.Test;

public class EchoClientTest {

    @Test
    public void test() throws Exception{
        EchoClient client = new EchoClient("127.0.0.1",9000);
        client.start();
    }
}
