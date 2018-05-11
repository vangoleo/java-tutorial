package com.leibangzhu.spring.bean.init;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@ComponentScan
@Configuration
public class AppConfiguration {

//    @Autowired
//    private Foo foo;

//    @Bean
//    public AlwaysBeingUsedBean alwaysBeingUsedBean() {
//        return new AlwaysBeingUsedBean();
//    }

//    @Bean
//    @Lazy
//    public RarelyUsedBean rarelyUsedBean() {
//        Foo foo2 = new Foo();   // 这里foo也是null
//        return new RarelyUsedBean();
//    }

    // 在实例化SomeBeanFactoryPostProcessor的时候，spring还没有初始化好Foo
    // @Autowired的Foo foo是null
//    @Bean(name = "someBeanFactoryPostProcessor1")
//    public SomeBeanFactoryPostProcessor someBeanFactoryPostProcessor1(){
//        SomeBeanFactoryPostProcessor bean = new SomeBeanFactoryPostProcessor();
////        bean.setFoo(foo);
//        return bean;
//    }

    @Bean
    public IBar bar(){
        return new Bar();
    }

}
