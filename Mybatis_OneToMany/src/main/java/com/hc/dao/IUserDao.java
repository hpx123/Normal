package com.hc.dao;

import com.hc.pojo.User;

import java.util.List;

public interface IUserDao {

    //查询
    List<User> findAll();
}