package com.hc.dao;

import com.hc.pojo.User;

import java.util.List;

public interface LoginDao {
    //用户名密码给Dao层，跟数据库匹配，如果找到了数据封装成User对象，返层业务层
    // service层，再返回给servlet是成功还是失败
    User checkLoginDao(String uname, String pwd);
    void checkLoginNewPwd(String newPwd, int id);
    void deleteDao(String name);
    User selectDao(String name);
    void insertDao(String name, String pwd, String sex, int age, String birth);

    List<User> selectAllDao();
}
