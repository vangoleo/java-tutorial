package com.leibangzhu.tutorial.rxjava2.operator;

import io.reactivex.Flowable;

import java.util.concurrent.TimeUnit;

public class TakeWhile {
    public static void main(String[] args) throws Exception {
        Flowable.interval(1, TimeUnit.SECONDS)
                .takeWhile(item -> item != 4)
                .subscribe(System.out::println);

        Thread.sleep(10 * 1000);
    }
}
