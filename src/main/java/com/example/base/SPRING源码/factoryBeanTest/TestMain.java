package com.example.base.SPRING源码.factoryBeanTest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableGpRegistrar
public class TestMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(TestMain.class);
        IHelloService is = applicationContext.getBean(IHelloService.class);
        System.out.println(is.say());

    }
}