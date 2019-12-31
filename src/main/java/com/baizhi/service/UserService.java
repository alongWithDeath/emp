package com.baizhi.service;

import com.baizhi.entity.User;

import java.util.List;

public interface UserService {
    //所有
    List<User> showAll();
    //登入
    User login(String name,String password);
    //注册
    void registerUser(User user);
    //修改
    void updateUser(User user);
    //逻辑删除
    void delete(String[] id);
    //模糊查询
    List<User>showLike(String key,String content);

}
