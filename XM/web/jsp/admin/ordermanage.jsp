<%@ page import="com.Javaone.pojo.AdminInfo" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Sky
  Date: 2022/10/17
  Time: 12:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>订单管理</title>
</head>
<body>
<table>
    <c:forEach items="${requestScope.goods}" var="goods">
        <div>
            <img src="/hello/${goods.gImgurl}">
        </div>
    </c:forEach>
</table>
</body>
</html>
