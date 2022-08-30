package com.example.springbooteurekaconsumer2.service;

import com.example.springbooteurekaconsumer2.entitry.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author:钟湘
 * @data: 14:58
 */

@Component
public class HystrixClientFallback3 implements FallbackFactory<UserService> {

    private static final Logger logger= LoggerFactory.getLogger(HystrixClientFallback3.class);

    @Override
    public UserService create(Throwable cause) {
        HystrixClientFallback3.logger.info("fallback; reason was: {}", cause.getMessage());

       return new UserService() {
           @Override
           public User query1(Integer id) {
               User user=new User();
               user.setName("xxxxxxxxxx");
               return user;
           }
       };
    }
}
