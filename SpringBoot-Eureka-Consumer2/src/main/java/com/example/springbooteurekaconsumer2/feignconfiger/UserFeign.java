package com.example.springbooteurekaconsumer2.feignconfiger;

import feign.Contract;
import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author:钟湘
 * @data: 17:35
 */

/**
 * 契约配置
 */

//@Configuration
public class UserFeign {

    // 配置feign的注释解析器为feign默认解析器而不是mvc解析器
    @Bean
    public Contract feignContract(){
        return new feign.Contract.Default();
    }

    @Bean
    Logger.Level feignLoggerLevel()
    {
        return Logger.Level.FULL;
    }

}
