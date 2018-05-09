package com.leibangzhu.javatutorial.asynchttpclient;

import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.ListenableFuture;
import org.asynchttpclient.Response;
import org.junit.Test;

public class AsyncHttpClientTest {

    private AsyncHttpClient asyncHttpClient = org.asynchttpclient.Dsl.asyncHttpClient();

    @Test
    public void test_get(){

        ListenableFuture<Response> responseFuture = asyncHttpClient.prepareGet("http://127.0.0.1:8080/hello").execute();

        Runnable callback = () -> {
            try {
                org.asynchttpclient.Response response = responseFuture.get();
                System.out.println(response.getResponseBody());
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
        responseFuture.addListener(callback, null);
    }

    @Test
    public void test_post(){

        org.asynchttpclient.Request postRequest = org.asynchttpclient.Dsl.post("http://127.0.0.1:8080/hello")
                .addFormParam("key1","hello")
                .addFormParam("key2","world")
                .build();

        ListenableFuture<org.asynchttpclient.Response> postResponseFuture = asyncHttpClient.executeRequest(postRequest);

        Runnable callback = () -> {
            try {
                org.asynchttpclient.Response response = postResponseFuture.get();
                System.out.println(response.getResponseBody());
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
        postResponseFuture.addListener(callback, null);
    }
}
