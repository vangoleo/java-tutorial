package com.leibangzhu.tutorial.rxjava2.operator;

import io.reactivex.Flowable;

public class SwitchIfEmpty {
    public static void main(String[] args) throws Exception {
        Flowable.empty()
                .switchIfEmpty(Flowable.just(3,4,5))
                .subscribe(System.out::println);

        Thread.sleep(3 * 1000);
    }
}
