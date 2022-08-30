package com.example.springbooteurekaconsumer2.service;

import com.example.springbooteurekaconsumer2.entitry.User;
import com.example.springbooteurekaconsumer2.feignconfiger.UserFeign;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author:钟湘
 * @data: 17:00
 */
//在使用@FeignClient注解的时候,是默认使用了ribbon进行客户端的负载均衡.
@FeignClient(value = "eureka-provider-service",configuration = UserFeign.class,fallback = HystrixClientFallback.class/*,fallbackFactory = HystrixClientFallback3.class*/)
public interface UserService {

//    @GetMapping("/query/{id}")
//    public User query(@PathVariable Integer id);

    @RequestLine(value = "GET  /query/{id}")
    public User query1(@Param Integer id);
}
