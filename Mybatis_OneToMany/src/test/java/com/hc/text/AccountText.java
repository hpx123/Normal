package com.hc.text;

import com.hc.dao.IAccountDao;
import com.hc.pojo.Account;
import com.hc.pojo.AccountUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class AccountText {

    private InputStream in;
    private SqlSession session;
    private IAccountDao accountDao;

    @Before
    public void init()throws IOException {
        //1.读取配置文件（将SqlMapConfig.xml中的信息读取出来
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂生产SqlSession对象
        session = factory.openSession();
        //4.使用SqlSession动态创建Dao接口的代理对象
        accountDao = session.getMapper(IAccountDao.class);
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
        List<Account> accounts = accountDao.findAll();
        for(Account account:accounts){
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }

    //查询所有用户和地址
    @Test
    public void textFindAllAccount(){
        List<AccountUser> accountUsers = accountDao.findAllAccountUser();
        for(AccountUser accountUser:accountUsers){
            System.out.println(accountUser);
        }
    }
}
