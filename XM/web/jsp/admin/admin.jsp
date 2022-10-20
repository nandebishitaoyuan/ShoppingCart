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
    <style type="text/css">
        body{
            font-family: "黑体";
        }
        table{
            width: 100%;
            border-collapse:collapse;
            text-align: center;
            border: 1px solid;
        }
        table tr td{
            border: 1px solid;
            height: 50px;
        }
        a{
            text-decoration: none;
            font-size: 35px;
        }
        .zt td{
            font-size: 30px;
        }
        div{
            width: 100%;
            text-align: center;
            margin-top: 50px;
        }
    </style>
</head>
<body>
<div>
    <h1>欢迎&nbsp${sessionScope.name}&nbsp使用管理员管理系统</h1>
</div>
<table>
    <tr class="zt">
        <td>管理员编号</td>
        <td>管理员名称</td>
        <td>管理员权限等级</td>
    </tr>
    <c:forEach items="${requestScope.adminList}" var="adminList">
        <tr>
            <td>${adminList.aid}</td>
            <td>${adminList.aName}</td>
            <td>${adminList.aLevel}</td>
        </tr>
    </c:forEach>
</table>
<div >
    <a href="${pageContext.request.contextPath}/jsp/admin/addAdmin.jsp">添加管理员</a>
    <a href="${pageContext.request.contextPath}/jsp/admin/updateAdmin.jsp">修改管理员信息</a>
    <a href="${pageContext.request.contextPath}/jsp/admin/deletAdmin.jsp">删除管理员</a>
</div>
</body>
</html>