package com.hc.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ResponseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //响应编码格式,响应中文给浏览器输出
        //resp.setHeader("content-type", "text/html;charest=utf-8");
        //resp.setContentType("text/plain;charest=utf-8");普通文本
        resp.setContentType("text/html;charest=utf-8");
    //1. 获取请求信息
        //获取请求头信息
        //获取请求行信息
        //获取请求数据
     //2.处理请求结果（数据库操作）
     //3.响应处理结果
        //设置响应头（都是键值对）
        resp.setHeader("mouse", "two fly birds");
        //设置响应实体
        resp.getWriter().write("<b>this is resp study</b>");

    }
}
