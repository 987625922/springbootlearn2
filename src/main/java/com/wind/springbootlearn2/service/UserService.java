package com.wind.springbootlearn2.service;

import com.wind.springbootlearn2.entity.User;

/**
 * 使用UserMapper类的接口
 * MybatisController的使用类接口
 * mybatis的使用
 */
public interface UserService {
    int add(User user);
}
