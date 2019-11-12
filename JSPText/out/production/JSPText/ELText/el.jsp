<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!--使用传统方式获取作用域对象-->
<h3>
    使用传统方式获取作用域对象
</h3>
<b><%=request.getParameter("uname")%></b><br/>
<b><%=request.getAttribute("str")%></b><br />
<c:if test=""></c:if>

