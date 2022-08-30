package com.example.springbooteurekaprovider2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@MapperScan(basePackages = "com.example.springbooteurekaprovider2.dao")
@SpringBootApplication
@EnableEurekaClient
public class SpringBootEurekaProvider2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootEurekaProvider2Application.class, args);
    }

}
