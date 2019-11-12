package com.hc.dao;

import com.hc.pojo.User;

import java.util.List;

public interface IUserDao {

    //查询
    List<User> findAll();

    //添加
    void saveUser(User user);

    //删除
    void deleteUser(Integer id);

    //更新
    void upDateUser(User user);

    //指定id查询
    User findByID(Integer id);

    //指定name模糊查询
    List<User> findByName(String name);

    //总个数
    Integer findTotal();
}