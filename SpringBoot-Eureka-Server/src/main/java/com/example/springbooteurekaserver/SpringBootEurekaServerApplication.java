package com.example.springbooteurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SpringBootEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootEurekaServerApplication.class, args);
    }

//    /**
//     * 新版（Spring Cloud 2.0 以上）的security默认启用了csrf检验，要在eurekaServer端配置security的csrf检验为false。（两种方法用一种就可以）
//     */
//    @EnableWebSecurity
//    static class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//        @Override
//        protected void configure(HttpSecurity http) throws Exception {
//            super.configure(http);//访问eureka控制台和actuator控制台时能做安全控制
//            //方法1：关闭csrf
//            http.csrf().disable();
//            //方法2：忽略/eureka/** 所有请求
//            http.csrf().ignoringAntMatchers("/eureka/**");
//        }
//    }
}
