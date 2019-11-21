package com.wind.springbootlearn2.service.impl;

import com.wind.springbootlearn2.entity.User;
import com.wind.springbootlearn2.mapper.UserMapper;
import com.wind.springbootlearn2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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

    /*
     * 根据id更新数据
     * */
    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    /*
     * 根据id删除数据
     * */
    @Override
    public void delect(Long id) {
        userMapper.delete(id);
    }

    /*
     * 测试事务使用
     * 添加一个数据然后抛出异常，查看事务是否执行
     * */
    @Override
    //TODO 开启注解事务
    @Transactional(propagation = Propagation.REQUIRED)
    public void transanctionTest() {
        User user = new User();
        user.setName("事务测试使用数据");
        userMapper.insert(user);
//       0不能做被除数，会抛出异常
        int i = 19 / 0;
    }
}
