package com.wind.springbootlearn2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {

    @RequestMapping("hello")
    public String hello() {
        return "index";
    }
}
