package com.wind.springbootlearn2.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/*
 * //todo springboot注解把配置文件自动映射到实体类
 * */
@Component
@PropertySource({"classpath:resource.properties"})
public class TestSetting {
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
