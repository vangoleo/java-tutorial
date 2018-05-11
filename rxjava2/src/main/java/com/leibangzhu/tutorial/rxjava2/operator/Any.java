package com.leibangzhu.tutorial.rxjava2.operator;

import io.reactivex.Flowable;

public class Any {
    public static void main(String[] args) throws Exception {
        Flowable.just(3,4,5)
                .any(integer -> integer == 3)
                .subscribe(System.out::println);

        Thread.sleep(3 * 1000);
    }
}
