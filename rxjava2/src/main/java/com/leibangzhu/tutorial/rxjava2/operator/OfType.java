package com.leibangzhu.tutorial.rxjava2.operator;

import io.reactivex.Flowable;

public class OfType {
    public static void main(String[] args) throws Exception {
        Flowable.just("a",1,3,"b")
                .ofType(Integer.class)      // 筛选出类型为Integer的元素
                .subscribe(System.out::println);

        Thread.sleep(3 * 1000);
    }
}
