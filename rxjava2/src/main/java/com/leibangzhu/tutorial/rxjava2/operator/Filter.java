package com.leibangzhu.tutorial.rxjava2.operator;

import io.reactivex.Flowable;

public class Filter {
    public static void main(String[] args) throws Exception {
        Flowable.just(1,2,3,4,5,6)
                .filter(integer -> integer % 2 == 0)
                .subscribe(System.out::println);

        Thread.sleep(10 * 1000);

    }
}
