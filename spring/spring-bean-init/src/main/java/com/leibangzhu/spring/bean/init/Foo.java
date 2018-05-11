package com.leibangzhu.spring.bean.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Foo {
    private String id = "foo";

    @Autowired
    private IBar bar;

    public Foo(){
        System.out.println("foo construct...");

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public IBar getBar() {
        return bar;
    }

    public void setBar(IBar bar) {
        this.bar = bar;
    }

    public void sayHello(){
        bar.sayHello();
    }
}
