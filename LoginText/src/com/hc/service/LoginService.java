package com.hc.service;

import com.hc.pojo.User;

import java.util.List;

/**
 * 登陆校验
 */

public interface LoginService {
    //判断密码是否正确
    User checkLoginService(String uname, String pwd);
    //修改密码，根据id查找修改
    void checkLoginNewPwdService(String newPwd, int id);
    //删除
    void deleteService(String name);
    //增加
    void insertService(String name, String pwd, String sex, int age, String birth);
    //查找
    User selectService(String name);

    List<User> selectAllSerclet();
}
