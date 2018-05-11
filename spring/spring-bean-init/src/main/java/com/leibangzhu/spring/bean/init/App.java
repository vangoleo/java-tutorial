package com.leibangzhu.spring.bean.init;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    // 这个sample用于测试:
    // 1. spring的bean加载顺序，比如A先加载，B后加载
    // 2. 初始化bean时，各个方法的执行顺序，比如静态变量，构造函数，init-method，InitializingBean，BeanPostProcessor，PostConstruct等
    public static void main(String... strings) throws InterruptedException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfiguration.class);
        System.out.println("Spring container started and is ready");
//        RarelyUsedBean bean = context.getBean(RarelyUsedBean.class);
//        bean.doSomething();

        Foo foo = context.getBean(Foo.class);
        foo.sayHello();

        Thread.sleep(5000);
    }
}
