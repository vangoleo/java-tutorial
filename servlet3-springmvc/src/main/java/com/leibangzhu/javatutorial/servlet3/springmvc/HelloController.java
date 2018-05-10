package com.leibangzhu.javatutorial.servlet3.springmvc;

import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.ListenableFuture;
import org.asynchttpclient.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
public class HelloController {

    private AsyncHttpClient asyncHttpClient = org.asynchttpclient.Dsl.asyncHttpClient();

    @RequestMapping(value = "/ok")
    public Callable<String> ok(){
        return () -> null;
    }

    @RequestMapping(value = "/ok2")
    public DeferredResult<String> ok2(){
        DeferredResult<String> result = new DeferredResult<>();

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.submit(() -> {
            try {
                Thread.sleep(1000 * 3);
            } catch (Exception e) {
                e.printStackTrace();
            }
            result.setResult("hello");
        });

        return result;
    }

    @RequestMapping(value = "/ok3")
    public DeferredResult<String> ok3() {
        DeferredResult<String> result = new DeferredResult<>();

        try {
            org.asynchttpclient.Request postRequest = org.asynchttpclient.Dsl.post("http://127.0.0.1:9091/ok")
                    .addFormParam("key1","hello")
                    .addFormParam("key2","world")
                    .build();

            ListenableFuture<Response> postResponseFuture = asyncHttpClient.executeRequest(postRequest);

            Runnable callback = () -> {
                try {
                    org.asynchttpclient.Response response = postResponseFuture.get();
                    result.setResult(response.getResponseBody());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            };
            postResponseFuture.addListener(callback, null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

}
