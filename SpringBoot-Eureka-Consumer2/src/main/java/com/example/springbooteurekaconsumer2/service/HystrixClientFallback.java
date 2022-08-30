package com.example.springbooteurekaconsumer2.service;

import com.example.springbooteurekaconsumer2.entitry.User;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author:钟湘
 * @data: 8:25
 */
@Component
public class HystrixClientFallback implements UserService {

    @Override
    public User query1(Integer id) {
        System.out.println("开启断路由");
        User user=new User();
        user.setName("钟湘");
        return user;
    }
}
