package com.leibangzhu.tutorial.dubbo.consumer;

import com.leibangzhu.javatutorial.dubbo.api.IHelloService;
import com.leibangzhu.javatutorial.dubbo.api.IUserService;
import com.leibangzhu.javatutorial.dubbo.api.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

//    @Autowired
//    private IHelloService helloService;

    @Autowired
    private IUserService userService;

//    @RequestMapping(value = "/hello")
//    public String hello(){
//        return helloService.hello("tom");
//    }

//    @RequestMapping(value = "/hello/{name}")
//    public String hello(@PathVariable("name") String name){
//        return helloService.hello(name);
//    }

    @RequestMapping(value = "/echo")
    public User echo(){
        User user = new User("tom",20,"12345");
        return userService.echo(user);
    }

}
