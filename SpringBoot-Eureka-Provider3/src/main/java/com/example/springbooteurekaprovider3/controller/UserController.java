package com.example.springbooteurekaprovider3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:钟湘
 * @data: 18:10
 */

@RestController
public class UserController {

    @GetMapping("/query2/{id}")
    public void query(){
        System.out.println("eureka-provider-service3");
    }
}
