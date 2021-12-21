package com.BeanFactory.BeanCountAndName;

import org.springframework.stereotype.Component;

@Component
public class BeanOne {

    BeanOne(){
        System.out.println("Object created for BeanOne");
    }
}
