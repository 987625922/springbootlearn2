package com.wind.springbootlearn2.controller;

import com.wind.springbootlearn2.domain.JsonData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * spring boot 日志的使用，spring boot已经导入slf4j日志，我们只需要使用就可以了，
 * 如果导入lombok，可以直接使用@Slf4j直接使用
 *
 */
@Slf4j
@RestController
@RequestMapping("/api/log")
public class LogController {

    @RequestMapping("/log")
    public Object log() {
        log.trace("这是一个trace日志");
        log.debug("这是一个debug日志");
        log.info("这是一个info日志");
        log.warn("这是一个warn日志");
        log.error("这是一个error日志");
        return new JsonData(200, "", "spring日志输出的学习");
    }

}
