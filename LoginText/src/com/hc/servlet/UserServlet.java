package com.hc.servlet;

import com.hc.pojo.User;
import com.hc.service.LoginService;
import com.hc.service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码格式
        req.setCharacterEncoding("utf-8");
        //获取响应编码格式
        resp.setContentType("text/html;charset=utf-8");
        String oper = req.getParameter("oper");
        //登陆
        if(oper.equals("log")){
            checkUserLogin(req,resp);
        }else if(oper.equals("pwd")){
            checkUserPwd(req, resp);
        }else if(oper.equals("del")){
            deleteUser(req, resp);
        }else if(oper.equals("ins")){
            inSertUser(req, resp);
        }else if(oper.equals("sel")){
            selUser(req, resp);
        }else if(oper.equals("selAll")){
            selAllUser(req, resp);
        }
    }

    //查找所有人信息
    private void selAllUser(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("eheh");
        List<User> us = new ArrayList<>();
        LoginService ls = new LoginServiceImpl();
        us = ls.selectAllSerclet();
        for (User u : us) {
            System.out.println(u);
        }
        ;
        req.setAttribute("allUse", us);
        System.out.println(us);
        req.getRequestDispatcher("user/selectAll.jsp").forward(req, resp);
    }

    //查找
    private void selUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("selName");
        LoginService ls = new LoginServiceImpl();
        User us = ls.selectService(name);
        req.setAttribute("selUse", us);
        req.getRequestDispatcher("show/show.jsp").forward(req, resp);

    }

    private void inSertUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //获取增加人的姓名
        String name = req.getParameter("insName");
        String pwd = req.getParameter("insPwd");
        String sex = req.getParameter("insSex");
        String age = req.getParameter("insAge");
        String birth = req.getParameter("insBirth");
        LoginService ls = new LoginServiceImpl();
        ls.insertService(name, pwd, sex, Integer.valueOf(age), birth);
        resp.sendRedirect("main/main.jsp");

    }

    //删除
    private void deleteUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //获取要删除的人的姓名
        String delName = req.getParameter("delName");
        LoginService ls = new LoginServiceImpl();
        ls.deleteService(delName);
        resp.sendRedirect("main/main.jsp");
    }

    //判断密码
    private void checkUserPwd(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //获取新密码
        String newPwd = req.getParameter("newPwd");
        User u = (User) req.getSession().getAttribute("use");
        int id = u.getId();
        //根据id调用服务层再调用Dao层
        LoginService ls = new LoginServiceImpl();
        ls.checkLoginNewPwdService(newPwd, id);
        resp.sendRedirect("login/login.jsp");

    }
    //处理登陆
    private void checkUserLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        //获取请求信息
        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        //处理请求信息
            // 获取service层对象
            LoginService ls = new LoginServiceImpl();
            User us = ls.checkLoginService(uname, pwd);
            System.out.println(uname + ":" + pwd);
            //校验
            //获取session对象
            HttpSession hs = req.getSession();
            hs.setAttribute("use", us);
            if(us != null){
                resp.sendRedirect("main/main.jsp");
            }else {
                req.setAttribute("flag", 0);
                req.getRequestDispatcher("login/login.jsp").forward(req, resp);
            }
        //响应处理结果
    }
}
