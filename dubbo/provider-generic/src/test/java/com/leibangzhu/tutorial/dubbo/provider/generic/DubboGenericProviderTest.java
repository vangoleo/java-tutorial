package com.leibangzhu.tutorial.dubbo.provider.generic;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DubboGenericProviderTest {

    @Test
    public void start_generic_provider_by_xml() throws Exception {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"dubbo-provider.xml"});
        context.start();
        System.out.println("Dubbo generic Provider started successfully...");
        System.in.read();
    }

    @Test
    public void start_generic_provider_by_java_api(){



    }


}
