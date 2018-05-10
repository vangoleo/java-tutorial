package com.leibangzhu.javatutorial.dubbo.provider;

import com.leibangzhu.javatutorial.dubbo.api.IHelloService;

public class HelloService implements IHelloService{
    @Override
    public String hello(String name) {
        return "Hello " + name;
    }
}
