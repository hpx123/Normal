package com.hc.dao.impl;

import com.hc.dao.IUserDao;
import com.hc.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class UserDaoImpl implements IUserDao {

    //定义工厂
    private SqlSessionFactory factory;
    private SqlSession session;

    public UserDaoImpl(SqlSessionFactory factory) {
        this.factory = factory;
    }

    @Before
    public void init(){
        //根据factory获取SqlSession对象
        session = factory.openSession();
    }

    @After
    public void destroy(){
        //提交事务
        session.commit();
        //关闭
        session.close();
    }

    public List<User> findAll() {
        //调用SqlSession中的方法，实现列表查询,返回的是一个结果集
        List<User> users = session.selectList("com.hc.dao.IUserDao.findAll");//参数是能获取配置信息的key
        return users;
    }

    public void saveUser(User user) {
        //调用方法
        session.insert("com.hc.dao.IUserDao.saveUser", user);
    }

    public void deleteUser(Integer id) {
        //调用方法
        session.update("com.hc.dao.IUserDao.deleteUser", id);
    }

    public void upDateUser(User user) {
        //调用方法
        session.update("com.hc.dao.IUserDao.upDateUser", user);
    }

    public User findByID(Integer id) {
        User user = session.selectOne("com.hc.dao.IUserDao.findById", id);
        return user;
    }

    public List<User> findByName(String name) {
        List<User> users = session.selectList("com.hc.dao.IUserDao.findAll");//参数是能获取配置信息的key
        return users;
    }

    @Override
    public Integer findTotal() {
        Integer count = session.selectOne("com.hc.dao.IUserDao.findById");
        return count;
    }
}
