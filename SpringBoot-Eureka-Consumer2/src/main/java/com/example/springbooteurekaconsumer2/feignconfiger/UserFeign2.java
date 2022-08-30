package com.example.springbooteurekaconsumer2.feignconfiger;

import feign.Contract;
import feign.Feign;
import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author:钟湘
 * @data: 10:36
 */

//@Configuration
public class UserFeign2 {

    // 配置feign的注释解析器为feign默认解析器而不是mvc解析器
    @Bean
    public Contract feignContract2(){
        return new feign.Contract.Default();
    }

    @Bean
    Logger.Level feignLoggerLevel2()
    {
        return Logger.Level.FULL;
    }

    //关闭feign的hystrix
    @Bean
    @Scope("prototype")
    public Feign.Builder feignBuilder(){
        return Feign.builder();
    }
}
