package com.leibangzhu.tutorial.rxjava2.operator;

import io.reactivex.Flowable;

public class LastElement {
    public static void main(String[] args) throws Exception {
        Flowable.just(1,2,3,4,5)
                .lastElement()     // 取最后一个元素
                .subscribe(System.out::println);

        Thread.sleep(10 * 1000);
    }
}
