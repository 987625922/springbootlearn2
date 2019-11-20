package com.wind.springbootlearn2.service.impl;

import com.wind.springbootlearn2.entity.User;
import com.wind.springbootlearn2.mapper.UserMapper;
import com.wind.springbootlearn2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 使用UserMapper类
 * MybatisController的使用类
 * mybatis的使用
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int add(User user) {
        userMapper.insert(user);
        int id = user.getId();
        return id;
    }
}
