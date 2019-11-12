<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/10/7
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>删除界面</title>
</head>
<body>
    <form action="/LoginText_war_exploded/user" method="post">
        <input type="hidden" name="oper" value="del">
    <li><label>请输入要删除的人的姓名：</label><input name="delName" type="text"></li>
        <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认删除"></li>
    </form>
</body>
</html>
