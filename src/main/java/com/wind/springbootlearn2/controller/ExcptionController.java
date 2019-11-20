package com.wind.springbootlearn2.controller;

import com.wind.springbootlearn2.domain.CustomException;
import com.wind.springbootlearn2.entity.UserControllerBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


/*
 * 异常捕获处理demo
 *
 * */
@RestController
public class ExcptionController {

    /**
     * 测试CustomExHandler里面的handlerException方法
     *
     * @return
     */
    @RequestMapping("/api/v1/test_ext")
    public Object testExt() {
        int i = 1 / 0;
        return new UserControllerBean(11, "123", "123", new Date());
    }


    /**
     * 测试CustomExHandler里面的handlerCustomException方法
     * 抛出CustomException异常
     *
     * @return
     */
    @RequestMapping("/api/v1/test_ext1")
    public Object testExt1() {

        throw new CustomException("111", "123");
    }



}
