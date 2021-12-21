package com.BeanFactory.BeanCountAndName;

import org.springframework.stereotype.Component;

@Component
public class BeanTwo {

    BeanTwo(){
        System.out.println("Object created for BeanTwo");
    }
}
