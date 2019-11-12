<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>登陆页面</title>
    <link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>
<div class="box_two">
    <div class="one">
        <span>${sessionScope.userName}博客</span>
    </div>
    <div>
        <form action="users" method="post" enctype="multipart/form-data" >
            <div class="fileInputContainer"><input class="fileInput" id="" type="file" name=""><br><br><br><br><br>
                <input type="submit" value="修改头像">
            </div>

        </form>

    </div>

    <a href="#uls_one">主页</a>
    <a href="#uls_two">我的博客</a>
    <a href="#uls_three">编辑资料</a>
</div>
<div class="box">
    <div class="box_one">

        <ul class="uls" id="uls_one" style="font-size: 50px;">
            <h2>我是一个主页</h2>

        </ul>
        <ul class="uls" id="uls_two" style="font-size: 50px;">
            <p>这是我的博客</p>

        </ul>
        <ul class="uls" id="uls_three" style="font-size: 50px;">
            <p>这是我的资料</p>
        </ul>
    </div>

</div>
</body>
</html>


