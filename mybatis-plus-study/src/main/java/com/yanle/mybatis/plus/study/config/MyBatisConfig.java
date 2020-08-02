package com.yanle.mybatis.plus.study.config;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.yanle.mybatis.plus.study.dao")
public class MyBatisConfig {

    // 注册一个分页插件
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    // 新版本不需要这个了， 是自动注入的
//    @Bean
//    public ISqlInjector SqlInjector() {
//        return new LogicsqlInjector();
//    }

    // 配置乐观锁插件
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }
}
