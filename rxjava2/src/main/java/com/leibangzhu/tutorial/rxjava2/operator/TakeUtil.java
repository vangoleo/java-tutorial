package com.leibangzhu.tutorial.rxjava2.operator;

import io.reactivex.Flowable;

import java.util.concurrent.TimeUnit;

public class TakeUtil {
    public static void main(String[] args) throws Exception {
        Flowable.just(1,2,3,4,5,6,7,8)
                .takeUntil(integer -> integer == 5)
                .subscribe(System.out::println);

        Thread.sleep(3 * 1000);


        // takeUntil也可以接受另外一个被观察者，当这个被观察者结束之后则停止第一个被观察者,例子如下：
        Flowable.interval(1, TimeUnit.SECONDS)
                .takeUntil(Flowable.timer(2,TimeUnit.SECONDS))
                .subscribe(System.out::println);

        Thread.sleep(3 * 1000);
    }
}
