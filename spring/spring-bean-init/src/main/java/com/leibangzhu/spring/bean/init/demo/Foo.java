package com.leibangzhu.spring.bean.init.demo;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Foo implements InitializingBean,DisposableBean {
    private String name;
    private IBar bar;

    public Foo(){
        System.out.println("Foo -> construct ...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Foo.destroy from DisposableBean");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Foo.afterPropertiesSet from InitializingBean");
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("Foo.postConstruct from @PostConstruct");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("Foo.preDestroy from @PreDestroy");
    }

    public void initMethod(){
        System.out.println("Foo.initMethod from init method");
    }

    public void destroyMethod(){
        System.out.println("Foo.destroyMethod from destroy method");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("Foo.setName");
    }

    public IBar getBar() {
        return bar;
    }

    public void setBar(IBar bar) {
        this.bar = bar;
    }

    public void hello(){
        bar.hello();
    }
}
