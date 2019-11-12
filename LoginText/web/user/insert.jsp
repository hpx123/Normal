<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/10/7
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查找页面</title>
</head>
<body>
    <form action="/LoginText_war_exploded/user" method="post">
        <input type="hidden" name="oper" value="ins">
        <li><label>请输入要增加人的姓名：</label><input name="insName" type="text"></li>
        <li><label>请输入要增加人的密码：</label><input name="insPwd" type="text"></li>
        <li><label>请输入要增加人的性别：</label><input name="insSex" type="text"></li>
        <li><label>请输入要增加人的年龄：</label><input name="insAge" type="text"></li>
        <li><label>请输入要增加人的生日：</label><input name="insBirth" type="text"></li>
        <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认增加"></li>
    </form>

</body>
</html>
