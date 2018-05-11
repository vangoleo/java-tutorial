package com.leibangzhu.tutorial.rxjava2.observable;


import io.reactivex.Flowable;

public class Defer {
    public static void main(String[] args) throws Exception {
        Flowable<String> flowable = Flowable.defer(() -> Flowable.just("1","2","3"));

        flowable.subscribe(System.out::println);
        flowable.subscribe(System.out::println);

        Thread.sleep(20 * 1000);
    }
}