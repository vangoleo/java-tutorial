package com.leibangzhu.tutorial.rxjava2.operator;

import io.reactivex.Flowable;

public class Skip {
    public static void main(String[] args) throws Exception {
        Flowable.just(1,2,3,4,5,6,7,8,9)
                .skip(2)        // 跳过前面2个元素
                .skipLast(2)    // 跳过末尾2个元素
                .subscribe(System.out::println);

        Thread.sleep(5 * 1000);
    }
}
