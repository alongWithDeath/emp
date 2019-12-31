package com.baizhi.dao;

import com.baizhi.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDAO {
    //查询所有
    List<User> queryAll();
    //登入
    User loginUser(String name);
    //注册
    void insertUser(User user);
    //修改
    void updateUser(User user);
    //逻辑删除、
    void delete(String[] id);
    //模糊查询
    List<User> queryLike(@Param("key") String key,@Param("content") String content,@Param("age") Integer age,@Param("salary") double salary);

}
