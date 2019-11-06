package com.wind.springbootlearn2.controller;

import com.wind.springbootlearn2.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


/*
 * 异常捕获处理demo
 *
 * */
@RestController
public class ExcptionController {

    @RequestMapping("/api/v1/test_ext")
    public Object testExt() {
        int i = 1 / 0;
        return new User(11, "123", "123", new Date());
    }

}
