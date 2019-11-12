package com.hc.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/*
如果请求的数据不存在，不会报错，返回null, 所以一般做一个判断，判断是否为空
 */
public class RequestServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //1.获取请求头数据(键值对）
        //获取请求方式
        String method = req.getMethod();
        System.out.println(method);
        //获取请求URL
        StringBuffer url = req.getRequestURL();
        System.out.println(url);
        //获取协议
        String h = req.getScheme();
        System.out.println(h);
    // 2.获取请求行数据
        //获取指定的请求行信息
        String value = req.getHeader("User-Agent");//根据键获取值
        System.out.println(value);
        //获取所有的请求行键的枚举
        Enumeration E = req.getHeaderNames();
        while(E.hasMoreElements()){
//            System.out.println(E.nextElement());
            String name = (String) E.nextElement();
            String temp = req.getHeader(name);
            System.out.println(name + ":" + value);
        }
        //3.获取用户数据
        //4.返回指定用户数据
        String name = req.getParameter("uname");//键 name表单属性值
        String pwd = req.getParameter("pwd");
        System.out.println(name + ":" + pwd);
        //多个选项
        //返回同键不同名的请求数据，返回数组
        String[] favs = req.getParameterValues("fav");
        if(favs != null){
            for(String fav:favs){
                System.out.println(fav);
            }
        }
        //获取所有用户请求数据的枚举集合(和获取请求行的枚举的方法是一样的）
        Enumeration e = req.getParameterNames();
    }


}
