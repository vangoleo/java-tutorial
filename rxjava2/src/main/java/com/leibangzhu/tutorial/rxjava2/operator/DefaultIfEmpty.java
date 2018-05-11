package com.leibangzhu.tutorial.rxjava2.operator;

import io.reactivex.Flowable;

public class DefaultIfEmpty {
    public static void main(String[] args) throws Exception {
        Flowable.empty()
                .defaultIfEmpty(1)
                .subscribe(System.out::println);

        Thread.sleep(3 * 1000);
    }
}
