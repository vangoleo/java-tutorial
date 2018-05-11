package com.leibangzhu.tutorial.rxjava2.observable;

import io.reactivex.Flowable;

import java.util.concurrent.TimeUnit;

public class Timer {
    public static void main(String[] args) throws Exception {
        Flowable.timer(3, TimeUnit.SECONDS)
                .subscribe(System.out::println);

        Thread.sleep(10 * 1000);
    }
}
