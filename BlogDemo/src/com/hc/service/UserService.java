package com.hc.service;

import com.hc.pojo.User;

public interface UserService{
    User checkLoginService(String name, String pwd);
    void submitUserService(String name, String pwd, String telenum, String sex,String birth);
    String updataPhotoService();
}
