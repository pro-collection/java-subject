package com.yanle.mybatis.plus.demo1.system.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com/yanle/mybatis/plus/demo1/system/dao")
public class MybatisPlusConfig {
}
