package com.leibangzhu.tutorial.rxjava2.operator;

import io.reactivex.Flowable;

public class StartWith {
    public static void main(String[] args) throws Exception {
        Flowable.just(4,5,6)
                .startWith(Flowable.just(1,2,3))
                .startWith(0)
                .subscribe(System.out::println);

        Thread.sleep(3 * 1000);
    }
}
