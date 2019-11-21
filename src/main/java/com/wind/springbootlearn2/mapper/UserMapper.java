package com.wind.springbootlearn2.mapper;

import com.wind.springbootlearn2.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

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
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
//获取返回的主键id
    int insert(User user);

    /**
     * 搜索全部
     */
    @Select("SELECT * FROM user")
    @Results({//映射替换
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "create_time", property = "createTime")
    })
    List<User> getAll();

    /**
     * 按照id查找
     */
    @Select("SELECT * FROM user WHERE id = #{id}")
    @Results({//映射替换
            @Result(column = "create_time", property = "createTime")
    })
    User findById(Long id);

    /**
     * 按照id更新数据
     */
    @Update("UPDATE user SET name=#{name} WHERE id =#{id}")
    void update(User user);

    /**
     * 按照id删除数据
     */
    @Delete("DELETE FROM user WHERE id =#{userId}")
    void delete(Long userId);

}
