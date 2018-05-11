package com.leibangzhu.tutorial.rxjava2.operator;

import io.reactivex.Flowable;

public class DistinctUntilChanged {
    public static void main(String[] args) throws Exception {
        Flowable.just(1,2,3,2,2,3)
                .distinctUntilChanged()
                .subscribe(System.out::println);

        Thread.sleep(3 * 1000);
    }
}
