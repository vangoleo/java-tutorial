package com.leibangzhu.tutorial.rxjava2.operator;

import io.reactivex.Flowable;

public class Contains {
    public static void main(String[] args) throws Exception {
        Flowable.just(3,4,5)
                .contains(3)           // 判断是否包含3
                .subscribe(System.out::println);

        Thread.sleep(3 * 1000);
    }
}
