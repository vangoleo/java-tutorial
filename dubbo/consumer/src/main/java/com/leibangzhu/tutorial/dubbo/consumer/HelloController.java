package com.leibangzhu.tutorial.dubbo.consumer;

import com.leibangzhu.javatutorial.dubbo.api.IHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private IHelloService helloService;

    @RequestMapping(value = "/hello")
    public String hello(){
        return helloService.hello("tom");
    }

    @RequestMapping(value = "/hello/{name}")
    public String hello(@PathVariable("name") String name){
        return helloService.hello(name);
    }

}
