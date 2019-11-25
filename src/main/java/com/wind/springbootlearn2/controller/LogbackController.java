package com.wind.springbootlearn2.controller;

import com.wind.springbootlearn2.domain.JsonData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * Logback日志输出框架使用的controller
 * 需要在resources中写Logback的配置文件logback-spring.xml
 *
 * */
@RestController
@RequestMapping("/api/logback")
public class LogbackController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /*
    * 测试Logback日志的输出
    * */
    @GetMapping("/test")
    public Object test() {

        logger.debug("this is debug");
        logger.info("this is info");
        logger.warn("this is warn");
        logger.error("this is error");
        return new JsonData(200, "", "日志输出成功");
    }

}
