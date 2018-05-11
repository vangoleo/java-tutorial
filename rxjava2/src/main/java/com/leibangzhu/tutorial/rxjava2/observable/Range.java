package com.leibangzhu.tutorial.rxjava2.observable;

import io.reactivex.Flowable;

public class Range {
    public static void main(String[] args) throws Exception {
        Flowable.range(0,5)
                .subscribe(System.out::println);

        Thread.sleep(10 * 1000);
    }
}
