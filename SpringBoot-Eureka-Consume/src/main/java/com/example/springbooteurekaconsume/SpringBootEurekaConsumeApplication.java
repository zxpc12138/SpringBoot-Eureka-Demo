package com.example.springbooteurekaconsume;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClients;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
//import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@MapperScan(basePackages = "com.example.springbooteurekaconsume.dao")
@LoadBalancerClients(value = {@LoadBalancerClient(name = "EUREKA-PROVIDER-SERVICE2",configuration = TestConfig.class),
                              @LoadBalancerClient(name = "EUREKA-PROVIDER-SERVICE",configuration = TestConfig2.class)
})
@EnableEurekaClient
@EnableHystrix
@EnableHystrixDashboard
public class SpringBootEurekaConsumeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootEurekaConsumeApplication.class, args);
    }

    /**
     * 这是因为在 Spring Boot 1.3版本中，会默认提供一个RestTemplate的实例Bean，
     * 而在 Spring Boot 1.4以及以后的版本中，这个默认的bean不再提供了，我们需要在Application启动时，手动创建一个RestTemplate的配置。
     * @return
     */
    @Bean
    @LoadBalanced
    //@LoadBalanced注解：开启负载均衡的功能，可以进行ip:port的替换，也就是将请求的地址中的服务逻辑名转为具体的服务地址
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
