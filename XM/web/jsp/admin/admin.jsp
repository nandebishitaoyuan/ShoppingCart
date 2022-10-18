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
    <title>管理员管理</title>
</head>
<body>
<div>
    <a href="/hello/allAdminServlet">查看全部管理员</a>
    <a href="/hello/jsp/admin/addAdmin.jsp">添加管理员</a>
    <a href="/hello/jsp/admin/updateAdmin.jsp">修改管理员信息</a>
    <a href="/hello/jsp/admin/deletAdmin.jsp">删除管理员</a>
</div>
</body>
</html>