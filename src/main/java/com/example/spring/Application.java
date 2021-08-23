package com.example.spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;


import java.util.Arrays;

//SpringBootApplication is a convenience annotation which adds the following:
//1. @Configuration: Tags the as a source of bean definitions for the application context
//2. @EnableAutoConfiguration: Tells Spring Boot to start adding bean based on classpath settings,
//        other beans, and various property settings. For example, if spring-webmvc is on the
//        classpath, this annotation flags the application as a web application and activates
//        key behaviours, such as setting up a Dispatcher Servlet
//@ComponentScan: Tells Spring to look for other components, configurations, and services in the
//com.example package, letting it find the controllers



@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(HelloController.class,args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx){
        return args -> {
            System.out.println("Let's inspect the beans provided by Spring Boot");
            String [] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }
        };
    }
}
