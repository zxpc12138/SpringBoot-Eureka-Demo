package com.example.springbooteurekaprovider4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringBootEurekaProvider4Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootEurekaProvider4Application.class, args);
    }

}
