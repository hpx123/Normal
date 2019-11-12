package com.ch.text;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Cookie的校验
 */
public class CookieServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码格式
        req.setCharacterEncoding("utf-8");
        //设置响应编码格式
        resp.setContentType("text/html;charset=utf-8");
        //处理请求信息
            //获取Cookie信息
            Cookie[] cks = req.getCookies();
            if(cks != null){

            }else {
                //请求转发
                req.getRequestDispatcher("page").forward(req, resp);
            }

    }
}
