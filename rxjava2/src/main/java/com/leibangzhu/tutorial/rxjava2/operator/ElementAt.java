package com.leibangzhu.tutorial.rxjava2.operator;

import io.reactivex.Flowable;

public class ElementAt {
    public static void main(String[] args) throws Exception {
        Flowable.just(1,2,3,4,5,6,7,8)
                .elementAt(2)      // 获取索引为2的元素，如果不存在则直接完成
                .subscribe(System.out::println);

        Thread.sleep(3 * 1000);

        Flowable.just(1,2,3,4,5)
                .elementAt(6,9)    // 获取索引为6的元素，如果不存在，则发射9
                .subscribe(System.out::println);

        Thread.sleep(3 * 1000);

        Flowable.just(1,2,3)
                .elementAtOrError(5)   // 获取索引为5的值，如果不存在则抛出异常
                .subscribe(System.out::println);

        Thread.sleep(3 * 1000);
    }
}
