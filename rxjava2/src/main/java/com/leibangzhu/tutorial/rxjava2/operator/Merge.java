package com.leibangzhu.tutorial.rxjava2.operator;

import io.reactivex.Flowable;

import java.util.concurrent.TimeUnit;

public class Merge {
    public static void main(String[] args) throws Exception {
        Flowable.merge(                    // 合并按照时间线并行执行
                Flowable.intervalRange(0,3,1,1,TimeUnit.SECONDS),
                Flowable.intervalRange(3,3,1,1,TimeUnit.SECONDS))
                .subscribe(System.out::println);

        Thread.sleep(10 * 1000);

        Flowable.mergeArray(
                Flowable.intervalRange(0,3,1,1,TimeUnit.SECONDS),
                Flowable.intervalRange(3,3,1,1,TimeUnit.SECONDS))
                .subscribe(System.out::println);

        Thread.sleep(10 * 1000);
    }
}
