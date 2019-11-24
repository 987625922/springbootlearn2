package com.wind.springbootlearn2.controller;

import com.wind.springbootlearn2.domain.JsonData;
import com.wind.springbootlearn2.entity.User;
import com.wind.springbootlearn2.utils.JsonUtils;
import com.wind.springbootlearn2.utils.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/*
 * redis的测试使用controller
 * */
@RestController
@RequestMapping("/api/redis")
public class RedisController {

    @Autowired
    private StringRedisTemplate redisTpl;

    @Autowired
    private RedisClient redisClient;


    /*
     * 测试添加redis数据
     * */
    @GetMapping("/test1")
    public Object addTest1() {
//        redisTpl.opsForValue().set("username", "添加redis数据");
        redisClient.set("username", "添加redis数据");
        return new JsonData(200, "", "redis添加数据成功");
    }

    /*
     * 测试查询redis数据
     * */
    @GetMapping("/test2")
    public Object getTest2() {
//        String username = redisTpl.opsForValue().get("username");
        String username = redisClient.get("username");
        return new JsonData(200, username, "redis查询数据成功");
    }
    /*
    * 测试添加json格式的redis数据
    * */
    @GetMapping("/set_user")
    public Object setUser() {
        User user = new User(13, "username", new Date());
        String userStr = JsonUtils.obj2String(user);
        redisClient.set("entity:user:13", userStr);
        return new JsonData(200, user, "user数据在redis中添加成功");
    }

    /*
    * 测试获取json格式的redis数据
    * */
    @GetMapping("/find_user")
    public Object findUser() {
        String userStr = redisClient.get("entity:user:13");
        User user = JsonUtils.string2Obj(userStr, User.class);
        return new JsonData(200, user, "user数据在redis中添加成功");
    }

}
