package com.example.springbooteurekaconsumer2.controller;

import com.example.springbooteurekaconsumer2.entitry.User;
import com.example.springbooteurekaconsumer2.service.UserService;
import com.example.springbooteurekaconsumer2.service.UserService2;
import com.example.springbooteurekaconsumer2.service.UserService3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:钟湘
 * @data: 16:56
 */
@RestController
public class TestController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserService2 userService2;

    @Autowired
    private UserService3 userService3;

//    @GetMapping("/query/{id}")
//    public User aa(@PathVariable Integer id){
//        return userService.query(id);
//    }


    @GetMapping("/query1/{id}")
    public User aaa(@PathVariable Integer id){
        return userService.query1(id);
    }

//    @GetMapping("/{servicename}")
//    public String bb(@PathVariable String servicename){
//        return userService2.findServiceInfoFromEurekaByServiceName(servicename);
//    }

    @GetMapping("/query2/{id}")
    public User bbb(@PathVariable Integer id){
        return userService3.query1(id);
    }

}
