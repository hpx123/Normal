package com.ch.text;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf=8");
        resp.setContentType("text/html;charset=utf-8");
        //获取请求信息
        String name = "胡程";
        //处理请求信息
            //创建session对象（同时也是获取）
         HttpSession hs = req.getSession();
         System.out.println(hs.getId());
         //存储数据
         hs.setAttribute("name", name);
    }
}
