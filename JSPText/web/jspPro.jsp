<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/9/27
  Time: 19:20
  To change this template use File | Settings | File Templates.
--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%--
    JSP的三种注释
    前端语言注释：
        会被转译，也会被发送，但不会被浏览器执行
    Java语言注释：
        会被转译，但是不会被Servlet执行
    JSP注释：
        不会被转译
     page errorPage="要跳转的路径"
--%>

<html>
<head>
    <base href="<%=basePath%>">
    <title>Title</title>
</head>
<body>

</body>
</html>
