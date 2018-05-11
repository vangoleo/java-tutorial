package com.leibangzhu.tutorial.rxjava2.observable;

import io.reactivex.Flowable;

public class Just {
    public static void main(String[] args) {
        Flowable.just("tom","leo","jerry")
                .subscribe(System.out::println);
    }
}
