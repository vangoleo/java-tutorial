package com.leibangzhu.tutorial.jdk.concurrency;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

public class CompletableFutureTest {

    @Test
    public void test_create1() throws Exception {
        // 通过new创建
        CompletableFuture<String> future = new CompletableFuture<>();

        Executors.newFixedThreadPool(5).submit(() -> {
            try {
                Thread.sleep(1000 * 5);
                future.complete("hello");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        System.out.println("Start to get value of future");
        System.out.print(future.get());
        System.out.println("Successfully get value of future");
    }

    @Test
    public void test_create2() throws Exception{
        // 通过completedFuture创建

        // 如果已经知道了结果，可以通过静态completedFuture()方法来创建一个CompletableFuture。
        // 如果某个方法的参数是一个CompletableFuture，可以通过这种方式创建CompletableFuture。
        CompletableFuture<String> future = CompletableFuture.completedFuture("hello");

        String result = future.get();
        System.out.println(result);
    }

    @Test
    public void test_create3() throws Exception {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "hello");
        System.out.println(future.get());
    }

    @Test
    public void test_process_result() throws Exception {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "hello");

        CompletableFuture<String> future2 = future1.thenApply(s -> s + "world" );

        System.out.println(future2.get());
    }

    @Test
    public void test_process_result2() throws Exception {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "hello");

        CompletableFuture future2 = future1.thenAccept(s -> System.out.println("return:" + s));

        future2.get();
    }

    @Test
    public void test_process_result3() throws Exception {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "hello");

        CompletableFuture future2 = future1.thenRun(() -> System.out.println("Completed"));

        future2.get();
    }











    @Test
    public void test_cancel() throws Exception {
        CompletableFuture<String> future = new CompletableFuture<>();

        Executors.newCachedThreadPool().submit(() -> {
            try {
                Thread.sleep(1000 * 5);
            } catch (Exception e) {
                e.printStackTrace();
            }
            future.cancel(false);
        });

        System.out.println(future.get());    // get CancellationException
    }



}
