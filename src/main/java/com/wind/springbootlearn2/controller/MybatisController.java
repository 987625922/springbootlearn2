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
     * <p>
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
        return new JsonData(200, user, "MybatisController的add接口请求成功");
    }

    /**
     * Userserviec的使用
     * <p>
     * 查找全部用户
     */
    @GetMapping("/getAll")
    public Object findAll() {
        return new JsonData(200, userService.getAll(), "查找全部用户");
    }

    /**
     * Userserviec的使用
     * <p>
     * 根据id查找
     */
    @GetMapping("/findById")
    public Object findById(Long id) {
        return new JsonData(200, userService.findById(id), "根据id查找");
    }

    /**
     * Userserviec的使用
     * <p>
     * 根据id更新数据
     */
    @GetMapping("/update")
    public Object update(User user) {
        userService.update(user);
        return new JsonData(200, null, "修改成功");
    }

    /**
     * Userserviec的使用
     * <p>
     * 根据id删除数据
     */
    @GetMapping("/delect")
    public Object delect(Long id) {
        userService.delect(id);
        return new JsonData(200, null, "删除成功");
    }


}
