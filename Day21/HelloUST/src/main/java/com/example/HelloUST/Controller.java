package com.example.HelloUST;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


    @RestController//before class,web application
    class Controller {
        @RequestMapping("/")//used before function
        public String hello() {
            return "Hello and Welcome to Prograd-UST training";
        }
    }

