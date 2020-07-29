package com.yanle.mybatis.plus.study.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.yanle.mybatis.plus.study.dao")
public class MyBatisConfig {
}
