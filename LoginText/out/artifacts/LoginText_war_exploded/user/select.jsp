<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/10/7
  Time: 20:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查找信息</title>
</head>
<body>
    <form action="/LoginText_war_exploded/user" method="post">
         <input type="hidden" name="oper" value="sel">
        <li><label>请输入要查找的姓名：</label><input name="selName" type="text"></li>
        <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认"></li>
    </form>
</body>
</html>
