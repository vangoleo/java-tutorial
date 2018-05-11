package com.leibangzhu.tutorial.rxjava2.operator;

import io.reactivex.Flowable;

public class Reduce {
    public static void main(String[] args) throws Exception {
        Flowable.just(1,2,3)
                .reduce((i,j) -> i + j)
                .subscribe(System.out::println);

        Thread.sleep(10 * 1000);


    }
}
