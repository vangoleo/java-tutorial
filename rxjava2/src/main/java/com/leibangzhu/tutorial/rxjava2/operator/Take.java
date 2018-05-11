package com.leibangzhu.tutorial.rxjava2.operator;

import io.reactivex.Flowable;

import java.util.concurrent.TimeUnit;

public class Take {
    public static void main(String[] args) throws Exception {
        Flowable.interval(1, TimeUnit.SECONDS)
                .take(5)
                .subscribe(System.out::println);

        Thread.sleep(20 * 1000);

        Flowable.interval(1,TimeUnit.SECONDS)
                .take(5,TimeUnit.SECONDS)
                .subscribe(System.out::println);

        Thread.sleep(10 * 1000);
    }
}
