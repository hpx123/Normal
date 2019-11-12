package com.hc.dao.Impl;

import com.hc.dao.UserDao;
import com.hc.pojo.User;

import java.sql.*;

public class UserDaoImpl implements UserDao {

    //检查账号密码是否正确
    @Override
    public User checkLoginDao(String name, String pwd) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User us = null;
        //加载驱动
        String sql = "select * from blog_user where uname=? and pwd=?";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/tutu?serverTimezone=UTC","root","111111");
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, pwd);
            rs = ps.executeQuery();
            while (rs.next()){
                us = new User();
                us.setUname(rs.getString("uname"));
                us.setPwd(rs.getString("pwd"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        close(conn, ps, rs);
        return us;
    }

    //注册
    @Override
    public void submitUserDao(String name, String pwd, String telenum, String sex, String birth) {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "insert into blog_user(uname,pwd,telenum,sex,birth) values (?,?,?,?,?)";

        //创建命令
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/tutu?serverTimezone=UTC","root","111111");
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, pwd);
            ps.setString(3, telenum);
            ps.setString(4, sex);
            ps.setString(5, birth);
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        close(conn, ps, null);
    }


    //上传照片
    @Override
    public void updatePhotoDao() {

    }


    //关闭资源
    public void close(Connection conn, PreparedStatement ps, ResultSet rs){
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(rs != null){
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
