package com.wind.springbootlearn2.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/*
 * 全局异常捕获类
 * */
@RestControllerAdvice
public class CustomExtHandler {

    private static final Logger LOG = LoggerFactory.getLogger(CustomExtHandler.class);

    //捕获Exception的异常，处理所有不可知的异常
    @ExceptionHandler(value = Exception.class)
    Object handlerException(Exception e, HttpServletRequest request) {
        LOG.error("url {},msg{}", request.getRequestURL(), e.getMessage());
        Map<String, Object> map = new HashMap<>();
        map.put("code", 100);
        map.put("msg", e.getMessage());
        map.put("url", request.getRequestURL());
        return map;
    }

    /**
     * 捕获CustomException的异常
     * 如果抛出的是CustomException的异常，就会进入这个方法
     * 如果抛出的是Exception异常就会进入上面的方法
     *
     * 1.异常抛出错误界面（注释的代码）
     * 2.异常抛出json
     * @param e
     * @param request
     * @return
     */
    @ExceptionHandler(value = CustomException.class)
    Object handlerCustomException(CustomException e, HttpServletRequest request) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("error.html");
//        modelAndView.addObject("msg", e.getMessage());
//        return modelAndView;
        Map<String, Object> map = new HashMap<>();
        map.put("code", e.getCode());
        map.put("msg", e.getMsg());
        map.put("url", request.getRequestURL());
        return map;
    }
}
