package com.hc.service.impl;

import com.hc.dao.Impl.UserDaoImpl;
import com.hc.dao.UserDao;
import com.hc.pojo.User;
import com.hc.service.UserService;

import java.io.File;

public class UserServiceImpl implements UserService {

    UserDao ud = new UserDaoImpl();

    @Override
    public User checkLoginService(String name, String pwd) {
        return ud.checkLoginDao(name, pwd);
    }

    @Override
    public void submitUserService(String name, String pwd, String telenum, String sex, String birth) {
            ud.submitUserDao(name, pwd, telenum, sex, birth);
    }

    @Override
    public String updataPhotoService() {
        //获取图片目标存的路径
        String filePath = "D:\\JavaProject\\BlogDemo\\web\\pictures";
        //判断文件夹是否存在，不存在则创建

        //获取当前路径

        ud.updatePhotoDao();
        return null;
    }


}
