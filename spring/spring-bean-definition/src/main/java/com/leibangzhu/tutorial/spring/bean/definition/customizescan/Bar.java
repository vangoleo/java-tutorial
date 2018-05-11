package com.leibangzhu.tutorial.spring.bean.definition.customizescan;

import org.springframework.stereotype.Component;

@Component
public class Bar {

    @Reference(interfaceClass = IHelloService.class)
    private IHelloService helloService;

    public void run(String name){
        String s = helloService.sayHello(name);
        System.out.println(s);
    }
}
