package com.leibangzhu.tutorial.rxjava2.operator;

import io.reactivex.Flowable;

public class Distinct {
    public static void main(String[] args) throws Exception {
        Flowable.just(1,2,3,3,4,5,5)
                .distinct()
                .subscribe(System.out::println);

        Thread.sleep(3 * 1000);
    }
}
