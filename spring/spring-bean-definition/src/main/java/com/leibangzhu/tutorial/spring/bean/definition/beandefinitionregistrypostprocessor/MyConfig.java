package com.leibangzhu.tutorial.spring.bean.definition.beandefinitionregistrypostprocessor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {
    @Bean
    MyConfigBean myConfigBean(){
        return new MyConfigBean();
    }
}
