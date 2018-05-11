package com.leibangzhu.tutorial.rxjava2.operator;

import io.reactivex.Flowable;

public class Last {
    public static void main(String[] args) throws Exception {
        Flowable.empty()
                .last(3)
                .subscribe(System.out::println);

        Thread.sleep(5 * 1000);
    }
}
