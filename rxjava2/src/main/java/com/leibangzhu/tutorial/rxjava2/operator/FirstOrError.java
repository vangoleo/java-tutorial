package com.leibangzhu.tutorial.rxjava2.operator;

import io.reactivex.Flowable;

public class FirstOrError {
    public static void main(String[] args) throws Exception {
        Flowable.empty()
                .firstOrError()     // 取第一个，如果为空，则抛出异常
                .subscribe(System.out::println);

        Thread.sleep(10 * 1000);
    }
}
