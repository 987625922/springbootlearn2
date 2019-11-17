package com.wind.springbootlearn2.intecpter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器的配置
 * <p>
 * 拦截器配置类，用于添加拦截器（如LoginIntercepter）
 */
@Configuration
public class CoustomerConfigrer implements WebMvcConfigurer {

    /**
     * 添加拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加拦截器，并配置需要拦截的路径
        registry.addInterceptor(new LoginIntercepter()).addPathPatterns("/api/intercepter/login");
        //把添加到的拦截器添加进去
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
