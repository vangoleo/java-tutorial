package com.leibangzhu.spring.bean.init;

import org.springframework.stereotype.Component;

//@Component
public class Bar implements IBar {

//    private String name = "bar";

    public Bar(){
        System.out.println("Bar construct...");
    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

    @Override
    public void sayHello() {
        System.out.println("I am bar...");
    }
}
