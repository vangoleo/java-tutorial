package com.leibangzhu.tutorial.rxjava2.operator;

import io.reactivex.Flowable;

public class Zip {
    public static void main(String[] args) throws Exception {
        Flowable.zip(
                Flowable.just(1,2,3),
                Flowable.just(4,5),
                (i,j) -> i + j)
                .subscribe(System.out::println);

        Thread.sleep(3 * 1000);
    }
}
