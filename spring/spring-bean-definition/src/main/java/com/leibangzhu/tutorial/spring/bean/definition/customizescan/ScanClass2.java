package com.leibangzhu.tutorial.spring.bean.definition.customizescan;

@CustomizeComponent
public class ScanClass2 {
    public void sayHello(String name){
        System.out.println("hello, " + name);
    }
}
