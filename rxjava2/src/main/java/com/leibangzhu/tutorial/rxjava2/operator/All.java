package com.leibangzhu.tutorial.rxjava2.operator;

import io.reactivex.Flowable;

public class All {
    public static void main(String[] args) throws Exception {
        Flowable.just(1,2,3,4)
                .all(integer -> integer >= 0)          // 判断所有的item是不是都>=0
                .subscribe(System.out::println);

        Thread.sleep(3 * 1000);
    }
}
