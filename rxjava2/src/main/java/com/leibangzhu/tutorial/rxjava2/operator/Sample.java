package com.leibangzhu.tutorial.rxjava2.operator;

import io.reactivex.Flowable;

import java.util.concurrent.TimeUnit;

public class Sample {
    public static void main(String[] args) throws Exception {
        Flowable.intervalRange(0,10,0,1, TimeUnit.SECONDS)
                .sample(2,TimeUnit.SECONDS)     // 每2秒采集最后一个元素
                .subscribe(System.out::println);

        Thread.sleep(10 * 1000);
    }
}
