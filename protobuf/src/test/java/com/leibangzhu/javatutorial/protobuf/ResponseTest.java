package com.leibangzhu.javatutorial.protobuf;

import org.junit.Test;

public class ResponseTest {

    @Test
    public void test() throws Exception {
        ResponseModel.Response response = create_response();

        byte[] bytes = response.toByteArray();

        ResponseModel.Response response2 = ResponseModel.Response.parseFrom(bytes);
        print(response2);
    }

    private ResponseModel.Response create_response(){
        ResponseModel.Response.Builder response = ResponseModel.Response.newBuilder();

        response.setId(10);
        response.setName("tom");
        response.addParams(ResponseModel.MapFieldEntry.newBuilder().setKey("hello").setValue("world").build());
        response.addParams(ResponseModel.MapFieldEntry.newBuilder().setKey("foo").setValue("bar").build());

        return response.build();
    }

    private void print(ResponseModel.Response response){
        System.out.println(response.getName());
        System.out.println(response.getId());
        response.getParamsList().forEach(s -> System.out.println(s.getKey() + s.getValue()));
    }
}
