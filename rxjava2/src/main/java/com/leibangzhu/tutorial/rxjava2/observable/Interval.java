package com.leibangzhu.tutorial.rxjava2.observable;

import io.reactivex.Flowable;

import java.util.concurrent.TimeUnit;

public class Interval {
    public static void main(String[] args) throws Exception {
        Flowable.interval(2,1, TimeUnit.SECONDS)
                .subscribe(System.out::println);

        Thread.sleep(10 * 1000);
    }
}
