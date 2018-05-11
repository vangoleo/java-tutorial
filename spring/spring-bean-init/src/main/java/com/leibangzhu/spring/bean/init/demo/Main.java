package com.leibangzhu.spring.bean.init.demo;

import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("classpath:beans.xml");
        Foo foo = (Foo) context.getBean("foo");
        foo.hello();
        context.destroy();
    }
}
