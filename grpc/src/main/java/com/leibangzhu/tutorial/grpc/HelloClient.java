package com.leibangzhu.tutorial.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class HelloClient {

    public static void main(String[] args) throws Exception {

        final ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:8080")
                .usePlaintext(true)
                .build();

        GreetingServiceGrpc.GreetingServiceBlockingStub stub = GreetingServiceGrpc.newBlockingStub(channel);

        HelloWorldProto.HelloRequest request = HelloWorldProto.HelloRequest.newBuilder()
                .setName("tom")
                .build();

        HelloWorldProto.HelloResponse response = stub.sayHello(request);

        System.out.println(response);

        channel.shutdownNow();
    }
}
