package com.leibangzhu.tutorial.rxjava2.operator;

import io.reactivex.Flowable;

import java.util.concurrent.TimeUnit;

public class SkipUtil {
    // skipUntil操作符接收一个被观察者，知道该被观察者发送事件之前，第一个被观察者所有发送的元素将被抛弃
    public static void main(String[] args) throws Exception {
        Flowable.intervalRange(0,10,0,1, TimeUnit.SECONDS)
                .skipUntil(Flowable.timer(3,TimeUnit.SECONDS))
                .subscribe(System.out::println);

        Thread.sleep(10 * 1000);
    }
}
