<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/10/6
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" import="java.util.*,com.hc.pojo.User" %>
<%@taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<style>
    .table-d table{ background:#F00}
    .table-d table td{ background:#F00}
</style>
<head>
    <base href="<%=basePath%>">
</head>
<body>
     <table border="8" cellspacing="0" cellpadding="0">
        <thead>
        <tr>
        <th>用户ID</th>
        <th>姓名</th>
        <th>性别</th>
        <th>年龄</th>
        <th>生日</th>
        </tr>
        </thead>
        <tr>
        <td>${sessionScope.use.id}</td>
        <td>${sessionScope.use.uname}</td>
        <td><c:choose>
            <c:when test="${sessionScope.use.sex}==0">
                <b>女</b>
            </c:when>
           <c:otherwise>
               <b>男</b>
           </c:otherwise>
        </c:choose></td>
        <td>${sessionScope.use.age}</td>
        <td>${sessionScope.use.birth}</td>
        </tr>
    </table>
     <li><a href="main/main.jsp" target="_parent">返回</a></li>
</body>
</html>
