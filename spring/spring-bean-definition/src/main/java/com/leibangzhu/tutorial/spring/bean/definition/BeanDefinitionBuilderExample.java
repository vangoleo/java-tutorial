package com.leibangzhu.tutorial.spring.bean.definition;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

public class BeanDefinitionBuilderExample {


    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        BeanDefinitionBuilder b = BeanDefinitionBuilder.rootBeanDefinition(MyBean.class)
                .addPropertyValue("str","myStringValue");
        beanFactory.registerBeanDefinition("myBean",b.getBeanDefinition());

        MyBean bean = beanFactory.getBean(MyBean.class);
        bean.doSomething();
    }

    public static class MyBean{

        private String str;

        public void setStr (String str) {
            this.str = str;
        }

        public void doSomething () {
            System.out.println("from MyBean " + str);
        }
    }



}
