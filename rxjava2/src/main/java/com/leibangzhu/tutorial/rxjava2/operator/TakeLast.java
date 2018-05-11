package com.leibangzhu.tutorial.rxjava2.operator;

import io.reactivex.Flowable;

import java.util.concurrent.TimeUnit;

public class TakeLast {
    public static void main(String[] args) throws Exception {
        Flowable.just(1,2,3,4,5,6,7)
                .takeLast(3)
                .subscribe(System.out::println);   // 最后3条数据

        Thread.sleep(5 * 1000);


        Flowable.just(1,2,3,4,5,6,7)
                .takeLast(3, TimeUnit.SECONDS)      // 最后3秒发送的数据
                .subscribe(System.out::println);

        Thread.sleep(5 * 1000);
    }
}
