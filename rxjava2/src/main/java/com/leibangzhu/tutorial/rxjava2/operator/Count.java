package com.leibangzhu.tutorial.rxjava2.operator;

import io.reactivex.Flowable;

public class Count {
    public static void main(String[] args) throws Exception {
        Flowable.just(1,2,3,4)
                .count()
                .subscribe(System.out::println);

        Thread.sleep(3 * 1000);
    }
}
