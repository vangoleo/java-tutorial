package com.leibangzhu.tutorial.spring.profiles.product;

import com.leibangzhu.tutorial.spring.profiles.IHelloService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProductHelloService implements IHelloService {

    @Value("#{config.name}")
    private String name;

    @Override
    public String sayHello() {
        return "Hello, I'm " + name + "; This is a product environment.";
    }
}
