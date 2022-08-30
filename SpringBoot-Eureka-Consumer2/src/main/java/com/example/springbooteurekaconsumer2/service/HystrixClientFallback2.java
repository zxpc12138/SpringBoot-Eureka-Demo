package com.example.springbooteurekaconsumer2.service;

import org.springframework.stereotype.Component;

/**
 * @author:钟湘
 * @data: 10:20
 */
@Component
public class HystrixClientFallback2 implements UserService2{
    @Override
    public String findServiceInfoFromEurekaByServiceName(String serviceName) {
        return "我还是我钟湘";
    }
}
