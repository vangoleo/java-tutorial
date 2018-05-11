package com.leibangzhu.tutorial.rxjava2.observable;

import io.reactivex.Flowable;

public class FromArray {
    public static void main(String[] args) {
        Flowable.fromArray(1,2,3,4,5)
                .subscribe(System.out::println);
    }
}
