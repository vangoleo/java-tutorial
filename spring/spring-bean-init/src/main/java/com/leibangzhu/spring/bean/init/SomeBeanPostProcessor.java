package com.leibangzhu.spring.bean.init;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class SomeBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("SomeBeanPostProcessor.postProcessBeforeInitialization ..." + beanName);
        if ((bean instanceof Foo)){
            Foo foo = (Foo)bean;
            foo.setBar(new Bar2());
            return foo;
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("SomeBeanPostProcessor.postProcessAfterInitialization ..." + beanName);
        return bean;
    }
}
