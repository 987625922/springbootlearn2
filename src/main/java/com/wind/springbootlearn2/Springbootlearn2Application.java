package com.wind.springbootlearn2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.servlet.MultipartConfigElement;

@SpringBootApplication
@ServletComponentScan //todo 扫描代码中的@WebServlet @WebFilter @WebListener 注解自动注册（servlet 3.0功能）
@MapperScan("com.wind.springbootlearn2.mapper")//todo 扫描mapper下面的类，开启mybatis的mapper使用
@EnableScheduling //todo 开启定时任务，扫描定时任务
@EnableAsync //todo 开启一个异步任务
public class Springbootlearn2Application {

    public static void main(String[] args) {
        // 避免netty冲突和elasticsearch
        System.setProperty("es.set.netty.runtime.available.processors", "false");
        SpringApplication.run(Springbootlearn2Application.class, args);
    }

    //对MultipartFile文件上传的大小进行配置
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize("10240KB");
        factory.setMaxRequestSize("1024000KB");
        return factory.createMultipartConfig();
    }
}
