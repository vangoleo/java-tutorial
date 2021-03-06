package com.leibangzhu.tutorial.spring.profiles;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-application-context.xml")
@ActiveProfiles("product")
public class SpringProfilesTest {

    @Autowired
    private IHelloService helloService;

    @Test
    public void test(){
        System.out.println(helloService.sayHello());
    }
}
