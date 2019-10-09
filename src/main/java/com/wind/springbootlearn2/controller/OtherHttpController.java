package com.wind.springbootlearn2.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/*
 * http协议的post，put，del请求
 * */
@RestController
public class OtherHttpController {
    private Map<String, Object> params = new HashMap<>();

    /*
     * 测试postMapping
     *post请求
     * localhost:8080/v1/login
     * postman的body选x-www-form-urlencoded
     * 里面的key和value分别为id为123和pwd为123
     * */
    @PostMapping("/v1/login")
    public Object login(String id, String pwd) {
        params.clear();
        params.put("id", id);
        params.put("pwd", pwd);
        return params;
    }

    /*
    * localhost:8080/v1/put?id=123
    * */
    @PutMapping("/v1/put")
    public Object put(String id) {
        params.clear();
        params.put("id", id);
        return params;
    }

    @DeleteMapping("/v1/del")
    public Object del(String id) {
        params.clear();
        params.put("id", id);
        return params;
    }
}
