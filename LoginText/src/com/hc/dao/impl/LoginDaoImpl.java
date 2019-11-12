package com.hc.dao.impl;

import com.hc.dao.LoginDao;
import com.hc.pojo.User;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LoginDaoImpl implements LoginDao {
    @Override
    public User checkLoginDao(String uname, String pwd) {
        //创建JDBC声明
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        //声明数据存储对象
        User us = null;
        try {
            //加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");//com.mysql.cj.jdbc.Driver
            //获取连接对象
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tutu?serverTimezone=UTC","root","111111");//?serverTimezone=UTC//serverTimezone=GMT%2B8&useSSL=false
            //创建Sql命令
            String sql1 = "select * from t_user where uname=? and pwd=?;";
            //创建Sql命令对象
            ps = conn.prepareStatement(sql1);
            //给占位符赋值
            ps.setString(1, uname);
            ps.setString(2,pwd);
            //执行
            rs = ps.executeQuery();
            //遍历执行结果
            while(rs.next()){
                us = new User();
                //给变量赋值
                us.setId(rs.getInt("id"));
                us.setUname(rs.getString("uname"));
                us.setPwd(rs.getString("pwd"));
                us.setSex(rs.getString("sex"));
                us.setAge(rs.getInt("age"));
                us.setBirth(rs.getString("birth"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            //关闭资源
            try {
                rs.close();
                ps.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        return us;
    }

    //修改
    @Override
    public void checkLoginNewPwd(String newPwd, int id) {
        //创建JDBC声明
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        //声明数据存储对象
        User us = null;
        try {
            //加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");//com.mysql.cj.jdbc.Driver
            //获取连接对象
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tutu?serverTimezone=UTC","root","111111");//?serverTimezone=UTC//serverTimezone=GMT%2B8&useSSL=false
            //创建Sql命令
            String sql1 = "update t_user set pwd=? where id=?";
            //创建Sql命令对象
            ps = conn.prepareStatement(sql1);
            //给占位符赋值
            ps.setString(1,newPwd);
            ps.setInt(2,id);
            ps.executeUpdate();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            //关闭资源
            try {
//                rs.close();
//                ps.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    //删除
    @Override
    public void deleteDao(String name) {
        //创建JDBC声明
        Connection conn = null;
        PreparedStatement ps = null;
        Result rs = null;
        try {
            //加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");//com.mysql.cj.jdbc.Driver
            //获取连接对象
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tutu?serverTimezone=UTC","root","111111");//?serverTimezone=UTC//serverTimezone=GMT%2B8&useSSL=false
            //创建Sql命令
            String sql = "delete from t_user where uname=?;";
            //创建命令
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.executeUpdate();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            //关闭资源
            try {
                ps.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //查找
    @Override
    public User selectDao(String name) {
        //创建JDBC声明
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        //声明数据存储对象
        User us = null;
        try {
            //加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");//com.mysql.cj.jdbc.Driver
            //获取连接对象
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tutu?serverTimezone=UTC","root","111111");//?serverTimezone=UTC//serverTimezone=GMT%2B8&useSSL=false
            //创建Sql命令
            String sql1 = "select * from t_user where uname=?";
            //创建Sql命令对象
            ps = conn.prepareStatement(sql1);
            //给占位符赋值
            ps.setString(1, name);
            //执行
            rs = ps.executeQuery();
            //遍历执行结果
            while(rs.next()){
                us = new User();
                //给变量赋值
                us.setId(rs.getInt("id"));
                us.setUname(rs.getString("uname"));
                us.setPwd(rs.getString("pwd"));
                us.setSex(rs.getString("sex"));
                us.setAge(rs.getInt("age"));
                us.setBirth(rs.getString("birth"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            //关闭资源
            try {
                rs.close();
                ps.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        return us;
    }

    //添加
    @Override
    public void insertDao(String name, String pwd, String sex, int age, String birth) {
        //创建JDBC声明
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //建立连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tutu?serverTimezone=UTC","root","111111");
            //命令
            String sql = "insert into t_user(uname,pwd,sex,age,birth) values (?,?,?,?,?);";
            //创建命令
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, pwd);
            ps.setString(3, sex);
            ps.setInt(4, age);
            ps.setString(5, birth);
            ps.executeUpdate();


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            //关闭资源
            try {
                ps.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return;
    }

    @Override
    public List<User> selectAllDao() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<User> us = new ArrayList<>();
        User u = null;
        try {
            //加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //建立连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tutu?serverTimezone=UTC","root","111111");
            //命令
            String sql = "select * from t_user";
            //创建命令
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                u = new User();
                u.setId(rs.getInt("id"));
                u.setUname(rs.getString("uname"));
                u.setPwd(rs.getString("pwd"));
                u.setSex(rs.getString("sex"));
                u.setAge(rs.getInt("age"));
                u.setBirth(rs.getString("birth"));
                us.add(u);
                System.out.println(u);
            }


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            //关闭资源
            try {
                rs.close();
                ps.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return us;
    }


}
