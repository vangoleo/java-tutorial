package com.leibangzhu.tutorial.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class HelloServer {
    public static void main(String[] args) throws Exception {

        Server server = ServerBuilder.forPort(8080)
                .addService(new GreetingServiceImpl())
                .build();

        server.start();

        System.out.println("Server started");

        server.awaitTermination();
    }
}
