package com.leibangzhu.tutorial.netty.echo;

import org.junit.Test;

public class EchoClientTest {

    @Test
    public void test() throws Exception{
        EchoClient client = new EchoClient("127.0.0.1",8000);
        client.start();
    }
}
