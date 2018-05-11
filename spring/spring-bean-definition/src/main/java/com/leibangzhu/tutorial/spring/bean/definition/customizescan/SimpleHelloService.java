package com.leibangzhu.tutorial.spring.bean.definition.customizescan;

public class SimpleHelloService implements IHelloService {
    @Override
    public String sayHello(String name) {
        return "hello, " + name;
    }
}
