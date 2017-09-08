package com.vysu.spring_tutorial.annotation_di;

import com.vysu.spring_tutorial.hibernate.DAO.SpitterDAO;
import com.vysu.spring_tutorial.hibernate.entity.Spitter;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class Starter {

    static private ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
    static private SpringApplication application = (SpringApplication) context.getBean("springApplication");
    static private SpitterDAO spitterDAO = (SpitterDAO) context.getBean("spitterDAOImpl");

    private static Spitter spitterOperation() {
        Spitter spitter = new Spitter();
        spitter.setCreatedDate(new Date());
        spitter.setPassword("12345");
        spitter.setEmail("den4ik@mail.ru");
        spitter.setUsername("Denis");
        spitter.setFullname(spitter.getUsername() + " Cherkasov");
        return spitter;
    }

    public static void main(String[] args) {
        application.outStringScope(4);
        System.out.println("Test");
        spitterDAO.addSpitter(spitterOperation());
    }
}
