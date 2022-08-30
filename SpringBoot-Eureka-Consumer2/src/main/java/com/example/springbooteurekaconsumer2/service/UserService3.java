package com.example.springbooteurekaconsumer2.service;

import com.example.springbooteurekaconsumer2.entitry.User;
import com.example.springbooteurekaconsumer2.feignconfiger.UserFeign;
import com.example.springbooteurekaconsumer2.feignconfiger.UserFeign2;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author:钟湘
 * @data: 18:07
 */

@FeignClient(value = "eureka-provider-service2",configuration = UserFeign2.class,fallback = HystrixClientFallback2.class)
public interface UserService3 {

    @RequestLine(value = "GET  /query2/{id}")
    public User query1(@Param Integer id);
}
