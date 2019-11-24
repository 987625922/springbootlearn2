package com.wind.springbootlearn2;


import com.wind.springbootlearn2.entity.User;
import com.wind.springbootlearn2.utils.JsonUtils;
import com.wind.springbootlearn2.utils.RedisClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/*
* redis的测试使用
* */
@RunWith(SpringRunner.class)  //底层用junit  SpringJUnit4ClassRunner
@SpringBootTest(classes = {Springbootlearn2Application.class})//启动整个springboot工程
public class RedisJsonTest {

    @Autowired
    private StringRedisTemplate strTpl;

    @Autowired
    private RedisClient redis;

    @Test
    public void testOne() {
        User u = new User();
        u.setAge(1);
        u.setPhone("22222");
        String str = JsonUtils.obj2String(u);
        strTpl.opsForValue().set("str", str);
        System.out.println(str);

    }

}
