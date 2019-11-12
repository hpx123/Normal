<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/10/6
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" import="java.util.*,com.hc.pojo.User" %>
<html>
<head>
    <base href="<%=basePath%>">
    <title>登陆页面</title>
</head>
<body>
    <h3>欢迎
    <span>${sessionScope.use.uname}</span>
    小仙女的登陆</h3>
    <ul class="ui-menu">
    <li><cite></cite><a href="user/userInfo.jsp">查看个人信息</a><i></i> </li>
    <li><cite></cite><a href="user/pwd.jsp">修改密码</a><i></i> </li>
    <li><cite></cite><a href="user/insert.jsp">增加信息</a><i></i> </li>
    <li><cite></cite><a href="user/delete.jsp">删除信息</a><i></i> </li>
    <li><cite></cite><a href="user/selectChoose.jsp">查找信息</a><i></i> </li>
    </ul>
    <li><a href="login/login.jsp" target="_parent">退出</a></li>
</body>
</html>
