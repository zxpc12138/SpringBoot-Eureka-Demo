package com.example.springbooteurekaserver2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringBootEurekaServer2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootEurekaServer2Application.class, args);
    }

}
