<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/10/6
  Time: 18:03
  To change this template use File | Settings | File Templates.
--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" import="java.util.*,com.hc.pojo.User" %>
<%@taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
    $(function () {
        if($("#newPwd").val() == ""){
            alert("新密码不能为空");
            return false;
        }else if ($("#cfPwd").val() == ""){
            alert("确认密码不能为空");
            return false
        }else if($("#cfPwd").val() != $("#newPwd").val()){
            return true;
        }

    })
</script>
<html>
<head>
    <title></title>
</head>
<body>
    <form action="/LoginText_war_exploded/user" method="post" id="fm">
        <input type="hidden" name="oper" value="pwd">
    <div style="font-size: 20px;color: blueviolet;font-weight: bold;"><span>修改密码信息</span></div>
    <li><label>新密码</label><input name="newPwd" id="newPwd" type="text" class="dfinput"></li>
    <li><label>确认密码</label><input name="newPwd" id="cfPwd" type="text" class="dfinput"></li>
    <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认修改"></li>
    </form>
</body>
</html>
