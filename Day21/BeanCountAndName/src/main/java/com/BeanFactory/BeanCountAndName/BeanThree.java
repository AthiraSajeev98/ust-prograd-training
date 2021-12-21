package com.BeanFactory.BeanCountAndName;

import org.springframework.stereotype.Component;

@Component
public class BeanThree {

    BeanThree(){
        System.out.println("Object created for BeanThree");
    }
}
