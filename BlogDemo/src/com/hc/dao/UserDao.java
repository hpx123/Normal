package com.hc.dao;

import com.hc.pojo.User;

public interface UserDao {
    User checkLoginDao(String name, String pwd);
    void submitUserDao(String name, String pwd, String telenum, String sex, String birth);
    void updatePhotoDao();
}
