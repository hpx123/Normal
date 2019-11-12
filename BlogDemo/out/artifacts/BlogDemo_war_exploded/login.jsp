<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/10/15
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>登陆页面</title>
    <link rel="stylesheet" type="text/css" href="css/login.css">

</head>

<body>
        <div class="login">
            <form method="post" action="/BlogDemo_war_exploded/users">
                <input type="hidden" name="oper" value="log">
                用户名: <input name="uname" type="text" class="uname"><br>
                &nbsp;密  码:&nbsp; <input name="pwd" type="text" class="pwd"><br><br>
                <a href="submit.jsp"><input type="button" value="注册" class="submit"></a>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="登陆" class="submit"><br>
                <c:if test="${flag==1}">
                    <br>
                    <span style="font-size: 15px;color: brown;font-weight: bold;" class="wrong">用户名或密码错误</span><br/>
                </c:if>
            </form>
        </div>


</body>
</html>
