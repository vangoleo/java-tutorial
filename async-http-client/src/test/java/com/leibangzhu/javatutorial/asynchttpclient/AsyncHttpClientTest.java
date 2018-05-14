package com.leibangzhu.javatutorial.asynchttpclient;

import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.ListenableFuture;
import org.asynchttpclient.Request;
import org.asynchttpclient.Response;
import org.junit.Test;

public class AsyncHttpClientTest {

    private AsyncHttpClient asyncHttpClient = org.asynchttpclient.Dsl.asyncHttpClient();

    @Test
    public void test_get() throws Exception {

        ListenableFuture<Response> responseFuture = asyncHttpClient.prepareGet("http://www.baidu.com").execute();

        Runnable callback = () -> {
            try {
                org.asynchttpclient.Response response = responseFuture.get();
                System.out.println(response.getResponseBody());
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
        responseFuture.addListener(callback, null);
        Thread.sleep(1000 * 10);
    }

    @Test
    public void test_get2() throws Exception {
        Request request = org.asynchttpclient.Dsl.get("http://www.baidu.com").build();

        ListenableFuture<org.asynchttpclient.Response> future = asyncHttpClient.executeRequest(request);

        Runnable callback = () -> {
            try {
                org.asynchttpclient.Response response = future.get();
                System.out.println(response.getResponseBody());
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
        future.addListener(callback, null);

        Thread.sleep(1000 * 10);
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
