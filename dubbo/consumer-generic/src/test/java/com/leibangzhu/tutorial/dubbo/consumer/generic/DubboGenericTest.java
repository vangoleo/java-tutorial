package com.leibangzhu.tutorial.dubbo.consumer.generic;

import com.alibaba.dubbo.rpc.service.GenericService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DubboGenericTest {

    @Test
    public void test(){

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dubbo-consumer.xml");
        context.start();

        GenericService helloService = (GenericService) context.getBean("helloService");
        Object tom = helloService.$invoke("hello",new String[]{"java.lang.String"},new Object[]{"tom"});
        Object jerry = helloService.$invoke("hello",new String[]{"java.lang.String"},new Object[]{"jerry"});
        System.out.println(tom);
        System.out.println(jerry);
    }
}
