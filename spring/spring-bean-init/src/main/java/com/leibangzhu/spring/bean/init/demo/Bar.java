package com.leibangzhu.spring.bean.init.demo;

public class Bar implements IBar{
    private String name;
    public Bar(){
        System.out.println("Bar -> construct ...");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("Bar.setName");
    }

    @Override
    public void hello() {
        System.out.println("Hello, I am Bar");
    }
}
