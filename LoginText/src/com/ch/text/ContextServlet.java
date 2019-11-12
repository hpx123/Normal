package com.ch.text;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

public class ContextServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取ServletContext对象
        //第一种
        ServletContext sc = this.getServletContext();
        //第二种
        ServletContext sc2 = this.getServletConfig().getServletContext();
        //第三种
        ServletContext sc3 = req.getSession().getServletContext();
        //存储
        sc.setAttribute("str", "胡程爱学习");
        //获取web.xml文件中全局配置数据
        //作用：将静态数据和代码进行解耦(相当于异地恋）
        sc.getInitParameter("name");
        //获取项目中web下的资源的绝对路径
        String path = sc.getRealPath("项目根目录中的路径");
        //获取项目中web下的资源的流对象
        InputStream is= sc.getResourceAsStream("项目根目录中的路径");
    }
}
