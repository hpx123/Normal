<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/10/8
  Time: 18:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
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
        <c:forEach items="${allUse}" var="str">
                <tr>
                    <td>${str.id}</td>
                    <td>${str.uname}</td>
                    <td><c:choose>
                        <c:when test="${str.sex}==0">
                            <b>女</b>
                        </c:when>
                        <c:otherwise>
                            <b>男</b>
                        </c:otherwise>
                    </c:choose></td>
                    <td>${str.age}</td>
                    <td>${str.birth}</td>
                </tr>

        </c:forEach>
    </table>


</body>
</html>
