package com.leibangzhu.tutorial.rxjava2.operator;

import io.reactivex.Flowable;

import java.util.concurrent.TimeUnit;

public class SkipWhile {
    // skipWhile操作符可以接受一个Predicate用于控制跳过开始一段数据，比如：
    public static void main(String[] args) throws Exception {
        Flowable.intervalRange(0,10,0,1, TimeUnit.SECONDS)
                .skipWhile( item -> item < 5)
                .subscribe(System.out::println);

        Thread.sleep(3 * 1000);

    }
}
