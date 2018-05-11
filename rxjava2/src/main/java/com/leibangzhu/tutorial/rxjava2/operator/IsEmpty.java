package com.leibangzhu.tutorial.rxjava2.operator;

import io.reactivex.Flowable;

public class IsEmpty {
    public static void main(String[] args) throws Exception {
        Flowable.just(1,2,3)
                .isEmpty()
                .subscribe(System.out::println);

        Thread.sleep(3 * 1000);
    }
}
