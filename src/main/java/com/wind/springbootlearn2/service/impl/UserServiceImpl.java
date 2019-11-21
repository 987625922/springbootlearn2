package com.wind.springbootlearn2.service.impl;

import com.wind.springbootlearn2.entity.User;
import com.wind.springbootlearn2.mapper.UserMapper;
import com.wind.springbootlearn2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 使用UserMapper类
 * MybatisController的使用类
 * mybatis的使用
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /*
     * 添加数据
     * */
    @Override
    public int add(User user) {
        userMapper.insert(user);
        int id = user.getId();
        return id;
    }

    @Override
    public List<User> getAll() {
        return userMapper.getAll();
    }

    /*
     * 根据id查找
     * */
    @Override
    public User findById(Long id) {
        return userMapper.findById(id);
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    public void delect(Long id) {
        userMapper.delete(id);
    }
}
