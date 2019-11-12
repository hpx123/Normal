package com.ch.text;

import com.hc.pojo.User;
import com.hc.service.LoginService;
import com.hc.service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置响应编码格式
        resp.setContentType("text/html;charset=utf-8");
        //获取请求信息（获取用户名和密码）
        String uname = (String) req.getParameter("uname");
        //转编码格式，用户名中文乱码问题(万能方式不分方式）
        uname = new String(uname.getBytes("iso8859-1"), "utf-8");
        String pwd = req.getParameter("pwd");
        System.out.println(uname + ":" + pwd);
        //处理请求信息
            //获取业务层对象
        LoginService is = new LoginServiceImpl();
        User u = is.checkLoginService(uname, pwd);
        System.out.println(u);
        //响应处理结果
        if(u != null){
            //创建Cookie三天登陆

            //重定向：解决了表单重复提交的问题，以及当前servlet无法处理的问题，
            //resp.sendRedirect("main");
        }else {
            //使用request对象实现不同Servlet的数据流转
            req.setAttribute("str", "用户名或密码错误");
            //请求转发后直接return结束
            req.getRequestDispatcher("page").forward(req,resp);
            return;
        }
    }
}
