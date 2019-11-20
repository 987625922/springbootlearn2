package com.wind.springbootlearn2.mapper;

import com.wind.springbootlearn2.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

/*
 * 访问数据库的接口
 *
 * mybatis的使用
 * */
public interface UserMapper {

    /**
     * 添加user
     */
    @Insert("INSERT INTO user(name,phone,create_time,age) VALUES(#{name},#{phone},#{createTime},#{age})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")//获取返回的主键id
    int insert(User user);

}
