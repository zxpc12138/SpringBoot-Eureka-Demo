package com.example.springbooteurekaprovider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//@EnableEurekaClient只适用于Eureka作为注册中心，@EnableDiscoveryClient 可以是其他注册中心(zookeeper,consul…)
@EnableEurekaClient
@SpringBootApplication
@MapperScan(basePackages = "com.example.springbooteurekaprovider.dao")
public class SpringBootEurekaProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootEurekaProviderApplication.class, args);
    }

}
