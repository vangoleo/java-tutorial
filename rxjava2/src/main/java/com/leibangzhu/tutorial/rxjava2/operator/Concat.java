package com.leibangzhu.tutorial.rxjava2.operator;

import io.reactivex.Flowable;

public class Concat {
    public static void main(String[] args) throws Exception {
        Flowable.concat(
                Flowable.just(1,2,3),
                Flowable.just(4,5,6))
                .subscribe(System.out::println);

        Thread.sleep(3 * 1000);

        Flowable.concatArray(
                Flowable.just(1),
                Flowable.just(2),
                Flowable.just(3),
                Flowable.just(4),
                Flowable.just(5))
                .subscribe(System.out::println);

        Thread.sleep(3 * 1000);
    }
}
