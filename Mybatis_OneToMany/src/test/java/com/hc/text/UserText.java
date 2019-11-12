package com.hc.text;

import com.hc.dao.IUserDao;
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

public class UserText {

    private InputStream in;
    private SqlSession session;
    private IUserDao userDao;

    @Before
    public void init()throws IOException{
        //1.读取配置文件（将SqlMapConfig.xml中的信息读取出来
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂生产SqlSession对象
        session = factory.openSession();
        //4.使用SqlSession动态创建Dao接口的代理对象
        userDao = session.getMapper(IUserDao.class);
    }

    @After
    public void destroy() throws IOException {
        //提交事务
        session.commit();
        session.close();
        in.close();
    }

    //查询全部
    @Test
    public void textFindAll(){
        //5.使用代理对象执行方法
        List<User> users = userDao.findAll();
        for(User user:users){
            System.out.println(user);
            System.out.println(user.getAccounts());
        }
    }

}
