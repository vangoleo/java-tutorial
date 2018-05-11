package com.leibangzhu.tutorial.rxjava2.operator;

import io.reactivex.Flowable;

import java.util.concurrent.TimeUnit;

public class CombineLatest {
    public static void main(String[] args) throws Exception {
        Flowable.combineLatest(
                Flowable.just(1,2,3),
                Flowable.intervalRange(0,3,1,1, TimeUnit.SECONDS),
                (i,j) -> i + j)
                .subscribe(System.out::println);

        Thread.sleep(10 * 1000);
    }
}
