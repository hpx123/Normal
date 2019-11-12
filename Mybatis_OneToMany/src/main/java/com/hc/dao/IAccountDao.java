package com.hc.dao;


import com.hc.pojo.Account;
import com.hc.pojo.AccountUser;

import java.util.List;

public interface IAccountDao  {

    //查询， 同时还要获取当前账户的所属用户信息
    List<Account> findAll();

    //查询用户的所有信息包括地址
    List<AccountUser> findAllAccountUser();

}
