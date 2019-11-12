<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/10/6
  Time: 12:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>学生登陆页面</title>
</head>
<body>
    <form action="/user" method="post">
        <input type="hidden" name="oper" value="log">
        用户名：<input type="text" name="uname" value="" /><br/>
        密码：<input type="password" name="pwd" value="" /><br/>
        <input type="submit" value="登陆"/><br/>
        <c:if test="${flag==0}">
            <span style="font-size: 15px;color: brown;font-weight: bold;">用户名或密码错误</span><br/>
        </c:if>
    </form>

</body>
</html>
