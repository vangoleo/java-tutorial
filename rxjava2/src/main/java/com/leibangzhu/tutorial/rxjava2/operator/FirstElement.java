package com.leibangzhu.tutorial.rxjava2.operator;

import io.reactivex.Flowable;

public class FirstElement {
    public static void main(String[] args) throws Exception {
        Flowable.just(1,2,3,4,5,6)
                .firstElement()      // 取第一个元素
                .subscribe(System.out::println);

        Thread.sleep(5 * 1000);
    }
}
