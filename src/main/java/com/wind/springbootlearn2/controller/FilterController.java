package com.wind.springbootlearn2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * filter的测试用controller
 */
@RestController
public class FilterController {

    @RequestMapping(value = "/api/filter/login")
    public String filterLogin(String username) {
        return "LoginFilter   成功通过";
    }
}
