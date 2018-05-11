package com.leibangzhu.tutorial.rxjava2.operator;

import io.reactivex.Flowable;

import java.util.concurrent.TimeUnit;

public class Timeout {
    public static void main(String[] args) throws Exception {
        Flowable.intervalRange(0,10,0,2, TimeUnit.SECONDS)
                .timeout(1,TimeUnit.SECONDS)      // 1秒后超时
                .subscribe(System.out::println);

        Thread.sleep(3 * 1000);

        Flowable.intervalRange(0,10,0,2, TimeUnit.SECONDS)
                .timeout(1,TimeUnit.SECONDS,Flowable.just(-1L))      // 1秒后超时
                .subscribe(System.out::println);

        Thread.sleep(3 * 1000);
    }
}
