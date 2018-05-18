package com.leibangzhu.tutorial.netty;

import org.junit.Test;

public class EchoServerTest {

    @Test
    public void test() throws Exception{
        EchoServer server = new EchoServer(9000);
        server.run();
    }

}
