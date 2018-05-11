package com.leibangzhu.tutorial.rxjava2.operator;

import io.reactivex.Flowable;

public class StartWithArray {
    public static void main(String[] args) throws Exception {
        Flowable.just(4,5,6)
                .startWithArray(1,2,3)
                .subscribe(System.out::println);

        Thread.sleep(3 * 1000);
    }
}
