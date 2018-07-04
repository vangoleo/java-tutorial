# 如何运行

1. 运行HelloServer
2. 运行HelloClient

# 关于Protobuf和gRPC自动生成的文件
以下的文件是自动生成的:
1. HelloWorldProto
2. GreetingServiceGrpc

其中HelloWorldProto是Protobuf相关的，包括了proto文件对应的消息和服务的Java定义。

GreetingServiceGrpc是dRPC相关的，用于生成stub。

# 关于proto文件
HelloWorldProto.java和GreetingServiceGrpc.java这两个文件都是根据proto文件，由maven插件自动生成的。

1. 首先创建一个文件`src/main/proto/helloworld.proto`。注意文件的路径在`src/main/proto`下。文件名随意。
2. 执行`mvn package`命令，就会生成以下2个文件:
    - `java-tutorial/grpc/target/generated-sources/protobuf/java/HelloWorldProto`
    - `java-tutorial/grpc/target/generated-sources/protobuf/grpc-java/GreetingServiceGrpc`
