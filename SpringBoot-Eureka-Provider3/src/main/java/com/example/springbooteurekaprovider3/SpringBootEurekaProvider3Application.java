package com.example.springbooteurekaprovider3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringBootEurekaProvider3Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootEurekaProvider3Application.class, args);
    }

}
