package com.leibangzhu.tutorial.rxjava2.operator;

import io.reactivex.Flowable;

import java.util.concurrent.TimeUnit;

public class AmbArray {
    public static void main(String[] args) throws Exception {
        Flowable.ambArray(          // 选择第一个发射元素的被观察者，其他的被抛弃
                Flowable.timer(1, TimeUnit.SECONDS),
                Flowable.just(3,4,5))
                .subscribe(System.out::println);

        Thread.sleep(10 * 1000);
        // 只处理第二个被观察者，输出为3，4，5
    }
}
