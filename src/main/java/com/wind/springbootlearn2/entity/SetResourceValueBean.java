package com.wind.springbootlearn2.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/*
 * //todo springboot注解把配置文件自动映射到实体类
 * */
@Component
//获取配置文件，使用@Value把值直接映射到变量中
@PropertySource({"classpath:resource.properties"})
public class SetResourceValueBean {
    @Value("${test.name}")
    private String name;
    @Value("${test.url}")
    private String url;

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
}
