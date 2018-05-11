package com.leibangzhu.tutorial.rxjava2.operator;

import io.reactivex.Flowable;

import java.util.ArrayList;

public class Collect {
    public static void main(String[] args) throws Exception {
        Flowable.just(1,2,3,4)
                .collect(ArrayList::new,ArrayList::add)
                .subscribe(System.out::println);

        Thread.sleep(3 * 1000);
    }
}
