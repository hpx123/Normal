<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/10/18
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <link rel="stylesheet" type="text/css" href="css/submit.css">
</head>
<body>
    <div class="submit">
        <form action="/BlogDemo_war_exploded/users" method="post">
            <input type="hidden" name="oper" value="sub">
             用户名：<input type="text" name="subnam"><br><br>
             密  码：&nbsp<input type="password" name="subpwd"><br><br>
             电  话：&nbsp<input type="text" name="subtel"><br><br>
             性  别：&nbsp<input name="subsex" type="radio" checked="checked" value="1"/>男
              <input name="subsex" type="radio" value="0"/>女<br><br>
             生  日：<input name="subbir" type="date" ><br><br><br>
             <input type="submit" name="submit2" value="注册" class="button">
        </form>
    </div>

</body>
</html>
