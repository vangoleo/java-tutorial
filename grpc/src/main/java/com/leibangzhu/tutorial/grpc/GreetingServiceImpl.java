package com.leibangzhu.tutorial.grpc;

import io.grpc.stub.StreamObserver;

public class GreetingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase {

    @Override
    public void sayHello(HelloWorldProto.HelloRequest request, StreamObserver<HelloWorldProto.HelloResponse> responseObserver) {

        System.out.println(request);

        HelloWorldProto.HelloResponse response = HelloWorldProto.HelloResponse.newBuilder()
                .setMessage("Hello " + request.getName())
                .build();

        responseObserver.onNext(response);

        responseObserver.onCompleted();
    }
}
