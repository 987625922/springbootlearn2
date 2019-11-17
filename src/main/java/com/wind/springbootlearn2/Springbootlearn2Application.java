package com.wind.springbootlearn2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;

import javax.servlet.MultipartConfigElement;

@SpringBootApplication
@ServletComponentScan //扫描代码中的@WebServlet @WebFilter @WebListener 注解自动注册
public class Springbootlearn2Application {

    public static void main(String[] args) {
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
