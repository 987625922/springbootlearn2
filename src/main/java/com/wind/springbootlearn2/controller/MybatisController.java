package com.wind.springbootlearn2.controller;

import com.wind.springbootlearn2.domain.JsonData;
import com.wind.springbootlearn2.entity.User;
import com.wind.springbootlearn2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * mybatis使用的controller
 */
@RestController
@RequestMapping("/api/mybatis/user")
public class MybatisController {

    @Autowired
    private UserService userService;

    /**
     * Userserviec的使用
     *
     * 添加一条数据到数据库中
     */
    @GetMapping("/add")
    public Object add() {
        User user = new User();
        user.setAge(12);
        user.setCreateTime(new Date());
        user.setName("MybatisController的user类添加实例");
        user.setPhone("12212121");
        userService.add(user);
        return new JsonData(200,user,"MybatisController的add接口请求成功");
    }

}
