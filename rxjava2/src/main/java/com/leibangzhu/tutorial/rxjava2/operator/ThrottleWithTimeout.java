package com.leibangzhu.tutorial.rxjava2.operator;

import io.reactivex.Flowable;

import java.util.concurrent.TimeUnit;

public class ThrottleWithTimeout {
    // 适用场景:假设有一个即时显示搜索结果的需求，要求一段时间用户不输入才响应请求搜索结果
    public static void main(String[] args) throws Exception {
        Flowable.intervalRange(0,10,0,1, TimeUnit.SECONDS)
                .throttleWithTimeout(2,TimeUnit.SECONDS)      // 2秒内有新数据则抛弃旧数据,直到2秒内一直没有新数据来，则发射最后来的一个数据
                .subscribe(System.out::println);

        Thread.sleep(15 * 1000);     // 只会输出一个数字9。

        // 等价于

        Flowable.intervalRange(0,10,0,1, TimeUnit.SECONDS)
                .debounce(2,TimeUnit.SECONDS)
                .subscribe(System.out::println);

        Thread.sleep(15 * 1000);
    }
}
