package com.hc.service.impl;

import com.hc.dao.LoginDao;
import com.hc.dao.impl.LoginDaoImpl;
import com.hc.pojo.User;
import com.hc.service.LoginService;

import java.util.List;

public class LoginServiceImpl implements LoginService {
    //声明Dao层对象(多态）
    LoginDao ld = new LoginDaoImpl();

    @Override
    public User checkLoginService(String uname, String pwd) {
        return ld.checkLoginDao(uname, pwd);
    }

    @Override
    public void checkLoginNewPwdService(String newPwd, int id) {
        ld.checkLoginNewPwd(newPwd, id);
    }

    @Override
    public void deleteService(String name) {
        ld.deleteDao(name);
    }

    @Override
    public void insertService(String name, String pwd, String sex, int age, String birth) {
        ld.insertDao(name, pwd, sex, age, birth);
    }

    @Override
    public User selectService(String name) {
        return ld.selectDao(name);
    }

    @Override
    public List<User> selectAllSerclet() {
        return ld.selectAllDao();
    }
}
