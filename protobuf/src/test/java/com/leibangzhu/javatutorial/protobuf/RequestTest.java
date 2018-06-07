package com.leibangzhu.javatutorial.protobuf;

import org.junit.Test;

public class RequestTest {

    @Test
    public void test() throws Exception{

        RequestModel.Request request = create_request();

        byte[] bytes = request.toByteArray();

        RequestModel.Request request2 = RequestModel.Request.parseFrom(bytes);
        print(request2);
    }

    private RequestModel.Request create_request(){
        RequestModel.Request.Builder request = RequestModel.Request.newBuilder();

        request.setId(10);
        request.setName("haha");
        request.putParams("hello","world");
        request.putParams("foo","bar");

        return request.build();
    }

    private void print(RequestModel.Request request){
        System.out.println(request.getId());
        System.out.println(request.getName());
        System.out.println(request.getParamsMap());
    }
}
