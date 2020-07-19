package com.yanle.mybatis.plus.demo1.system.config.filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

@Configuration
public class CustomFilterConfig {
    @Bean
    public Filter accessAuthFilter(){
        return new AccessAuthFilter();
    }
}
