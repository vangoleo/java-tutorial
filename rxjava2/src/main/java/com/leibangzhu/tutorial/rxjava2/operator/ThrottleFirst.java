package com.leibangzhu.tutorial.rxjava2.operator;

import io.reactivex.Flowable;

import java.util.concurrent.TimeUnit;

public class ThrottleFirst {
    public static void main(String[] args) throws Exception {
        Flowable.intervalRange(0,10,0,1, TimeUnit.SECONDS)
                .throttleFirst(1,TimeUnit.SECONDS)      // 在一段时间内只响应第一个事件。比如一段时间内连续点击按钮，只执行第一次点击操作
                .subscribe(System.out::println);

        Thread.sleep(10 * 1000);
    }
}
