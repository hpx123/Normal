package com.hc.text;

import com.hc.dao.IUserDao;
import com.hc.dao.impl.UserDaoImpl;
import com.hc.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatisText {

    private InputStream in;
    private IUserDao userDao;

    @Before
    public void init()throws IOException{
        //1.读取配置文件（将SqlMapConfig.xml中的信息读取出来
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂对象,创建Dao对象
        userDao = new UserDaoImpl(factory);
    }

    @After
    public void destroy() throws IOException {
        in.close();
    }

    //查询全部
    @Test
    public void textFindAll(){
        //5.使用代理对象执行方法
        List<User> users = userDao.findAll();
        for(User user:users){
            System.out.println(user);
        }
    }

    //保存
    @Test
    public void textSave(){
        User user = new User();
        user.setUsername("杨伊琳");
        user.setSex('女');
        user.setAddress("西安邮电大学安美南3617");
        user.setBirthday(new Date());

        //5.使用代理对象执行方法
        userDao.saveUser(user);
    }

    //删除
    @Test
    public void textDelete(){
        userDao.deleteUser(1);
    }

    //更新
    @Test
    public void textUpDate(){
        User user = new User();
        user.setUsername("杨倩");
        user.setSex('女');
        user.setAddress("西安邮电大学安美南3617");
        user.setBirthday(new Date());

        userDao.upDateUser(user);
    }

    //指定id查找
    @Test
    public void textFindById(){
        userDao.findByID(2);
    }


    //指定name模糊查找
    @Test
    public void textFindByName(){
        List<User> users = userDao.findByName("%杨%");
        for (User user : users){
            System.out.println(user);

        }

    }


}
