package com.leibangzhu.tutorial.spring.bean.definition;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;

import java.util.Date;

public class GenericBeanDefinitionExample {

    public static void main(String[] args) {
        DefaultListableBeanFactory context = new DefaultListableBeanFactory();

        GenericBeanDefinition gbd = new GenericBeanDefinition();
        gbd.setBeanClass(MyBean.class);

        MutablePropertyValues mpv = new MutablePropertyValues();
        mpv.add("date",new Date());

        gbd.setPropertyValues(mpv);

        context.registerBeanDefinition("myBeanName",gbd);

        MyBean bean = context.getBean(MyBean.class);
        bean.doSomething();
    }

    public static class MyBean {

        private Date date;

        public void doSomething(){
            System.out.println("from my bean, date: " + date);
        }

        public void setDate(Date date){
            this.date = date;
        }
    }
}
