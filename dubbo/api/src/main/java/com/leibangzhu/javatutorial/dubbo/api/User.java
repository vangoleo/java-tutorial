package com.leibangzhu.javatutorial.dubbo.api;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private int age;
    private String mobile;

    public User(String name,int age,String mobile){
        this.name = name;
        this.age = age;
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getMobile() {
        return mobile;
    }
}
