package com.leibangzhu.tutorial.spring.bean.definition;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;

public class InjectOtherBeans {

    public static void main(String[] args) {
        DefaultListableBeanFactory context = new DefaultListableBeanFactory();

        GenericBeanDefinition beanOtherDef = new GenericBeanDefinition();
        beanOtherDef.setBeanClass(MyOtherBean.class);
        context.registerBeanDefinition("other",beanOtherDef);

        GenericBeanDefinition beanDef = new GenericBeanDefinition();
        beanDef.setBeanClass(MyBean.class);
        MutablePropertyValues mpv = new MutablePropertyValues();
        mpv.addPropertyValue("otherBean",context.getBean("other"));
        beanDef.setPropertyValues(mpv);
        context.registerBeanDefinition("myBean",beanDef);

        MyBean bean = context.getBean(MyBean.class);
        bean.doSomething();
    }

    public static class MyBean {
        private MyOtherBean otherBean;

        public void setOtherBean (MyOtherBean otherBean) {
            this.otherBean = otherBean;
        }

        public void doSomething () {
            otherBean.doSomething();
        }
    }

    public static class MyOtherBean {

        public void doSomething () {
            System.out.println("from other bean ");
        }
    }


}
