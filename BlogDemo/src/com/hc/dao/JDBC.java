package com.hc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBC {
    Connection conn = null;
    PreparedStatement ps = null;
    public void connection(String sql){

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/tutu?serverTimezone=UTC","root","111111");
            ps = conn.prepareStatement(sql);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }
}
