package com.leibangzhu.tutorial.rxjava2.operator;

import io.reactivex.Flowable;

import java.util.concurrent.TimeUnit;

public class ThrottleLast {
    public static void main(String[] args) throws Exception {
        Flowable.intervalRange(0,10,0,1, TimeUnit.SECONDS)
                .throttleLast(2,TimeUnit.SECONDS)
                .subscribe(System.out::println);

        Thread.sleep(10 * 1000);

        // 等价于

        Flowable.intervalRange(0,10,0,1, TimeUnit.SECONDS)
                .sample(2,TimeUnit.SECONDS)               // 每2秒钟采集最后一个元素
                .subscribe(System.out::println);

        Thread.sleep(10 * 1000);




    }
}
