<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/10/7
  Time: 22:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>展示页面</title>
</head>
<body>
<c:choose>
    <c:when test="${selUse!=null}">
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
                <td>${selUse.id}</td>
                <td>${selUse.uname}</td>
                <td><c:choose>
                    <c:when test="${selUse.pwd}==0">
                        <b>女</b>
                    </c:when>
                    <c:otherwise>
                        <b>男</b>
                    </c:otherwise>
                </c:choose></td>
                <td>${selUse.age}</td>
                <td>${selUse.birth}</td>
            </tr>
        </table>
    </c:when>
    <c:otherwise>
        <b>无该用户名信息</b>
    </c:otherwise>
</c:choose>

<li><a href="main/main.jsp" target="_parent">返回</a></li>
</body>
</html>
