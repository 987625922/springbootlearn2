package com.wind.springbootlearn2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * filter的测试用controller
 * intercepter拦截器的测试使用controller
 */
@RestController
public class FilterController {

    @RequestMapping(value = "/api/filter/login")
    public String filterLogin(String username) {
        System.out.println("LoginFilter   成功通过");
        return "LoginFilter   成功通过";
    }

    @RequestMapping(value = "/api/intercepter/login")
    public String intercepterLogin() {
        System.out.println("LoginIntercepter  成功通过");
        return "LoginIntercepter  成功通过";
    }
}
