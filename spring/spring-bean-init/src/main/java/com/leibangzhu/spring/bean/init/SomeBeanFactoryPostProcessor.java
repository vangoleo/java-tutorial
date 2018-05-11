package com.leibangzhu.spring.bean.init;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class SomeBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("SomeBeanFactoryPostProcessor ...");
    }

//    public void setFoo(Foo foo){
//        //System.out.println(foo.getId());
//    }
}
