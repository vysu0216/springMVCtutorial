package com.vysu.spring_tutorial.annotation_di;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Starter {

    static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
    public static void main(String[] args) {
        SpringApplication application = (SpringApplication) context.getBean("springApplication");
        application.outStringScope(4);
        System.out.println("Test");
    }
}
