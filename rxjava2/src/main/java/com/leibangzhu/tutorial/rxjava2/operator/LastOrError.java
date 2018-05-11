package com.leibangzhu.tutorial.rxjava2.operator;

import io.reactivex.Flowable;

public class LastOrError {
    public static void main(String[] args) throws Exception {
        Flowable.empty()
                .lastOrError()    // 取出最后一个元素，如果为空，则抛出异常
                .subscribe(System.out::println);

        Thread.sleep(5 * 1000);
    }
}
