package com.example.springbooteurekaconsumer2.service;

import com.example.springbooteurekaconsumer2.feignconfiger.UserFeign;
import com.example.springbooteurekaconsumer2.feignconfiger.UserFeign2;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author:钟湘
 * @data: 9:35
 */

@FeignClient(name = "xxxx",url = "http://localhost:8080/",configuration = UserFeign2.class,fallback = HystrixClientFallback2.class)
public interface UserService2 {

//    @GetMapping(value = "/eureka/apps/{servicename}")
//    public String test(@PathVariable String servicename);

    @RequestLine("GET /eureka/apps/{serviceName}")
    public String findServiceInfoFromEurekaByServiceName(@Param("serviceName") String serviceName);
}
