package com.BeanFactory.BeanCountAndName;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class BeanCountAndNameApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(BeanCountAndNameApplication.class, args);
        String[] beanName = context.getBeanDefinitionNames();

        System.out.println("**********************************************");
        for (String bean : beanName) {
            System.out.println(bean);
        }
        System.out.println("**********************************************");
        int beancount = context.getBeanDefinitionCount();

        System.out.println("Number of beans : " + beancount);
    }

}
