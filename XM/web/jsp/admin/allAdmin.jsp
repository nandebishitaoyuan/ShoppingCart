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
  <title>全部管理员</title>
</head>
<body>
<table align="center" border="1px solid">
  <tr>
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
</body>
</html>
