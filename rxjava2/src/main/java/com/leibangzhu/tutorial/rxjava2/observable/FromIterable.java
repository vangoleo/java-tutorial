package com.leibangzhu.tutorial.rxjava2.observable;

import io.reactivex.Flowable;

import java.util.ArrayList;
import java.util.List;

public class FromIterable {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        Flowable.fromIterable(list)
                .subscribe(System.out::println);
    }
}
