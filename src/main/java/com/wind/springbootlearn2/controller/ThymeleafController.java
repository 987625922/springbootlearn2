package com.wind.springbootlearn2.controller;

import com.wind.springbootlearn2.entity.SetResourceValueBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * thymeleaf的Controller页面
 * 主要学如何使用thymeleaf
 */
@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {

    @Autowired
    private SetResourceValueBean setResourceValueBean;

    /**
     * 使用thymeleaf
     * 直接打开templates资源目录下的index.html网页
     */
    @RequestMapping("hello")
    public String hello() {
        return "index";
    }


    @RequestMapping("setValue")
    public String setValue(ModelMap modelMap){
        modelMap.addAttribute("value", setResourceValueBean);
        return "admin/info";
    }
}