package com.leibangzhu.tutorial.rxjava2.operator;

import io.reactivex.Flowable;

import java.util.concurrent.TimeUnit;

public class SequenceEqual {
    public static void main(String[] args) throws Exception {
        // 判断发射的元素是否一样。只关心两个发射队列的元素，元素发射顺序和最终状态，而不关心时间
        Flowable.sequenceEqual(
                Flowable.just(0L,1L,2L),
                Flowable.intervalRange(0,3,0,1, TimeUnit.SECONDS))
                .subscribe(System.out::println);

        Thread.sleep(5 * 1000);

        Flowable.sequenceEqual(
                Flowable.just(0,1,2),
                Flowable.intervalRange(0,3,0,1, TimeUnit.SECONDS),
                (i,j) -> i.longValue() == j.longValue())          // 使用什么规则判断两个元素是相等的
                .subscribe(System.out::println);

        Thread.sleep(5 * 1000);
    }
}
