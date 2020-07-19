package com.yanle.mybatis.plus.demo1.system.config.security;

import com.yanle.mybatis.plus.demo1.system.config.interceptor.AccessAuthHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SecurityMvcConfigurer implements WebMvcConfigurer {

    private AccessAuthHandlerInterceptor accessAuthHandlerInterceptor;

    public SecurityMvcConfigurer(AccessAuthHandlerInterceptor accessAuthHandlerInterceptor) {
        this.accessAuthHandlerInterceptor = accessAuthHandlerInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry
                .addInterceptor(accessAuthHandlerInterceptor)
                .excludePathPatterns("/static/**")
                .addPathPatterns("/**");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login.html");
        registry.addViewController("/403").setViewName("403.html");
    }
}
