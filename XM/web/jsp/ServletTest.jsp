<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Sky
  Date: 2022/10/11
  Time: 9:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/hello/Admin" method="Post">
    <input type="submit" value="cs">
</form>
<c:forEach items="${requestScope.adminInfoList}" var="admin">
    <tr>
        <td>${admin.aid}</td>
        <td>${admin.aName}</td>
        <td>${admin.aPwd}</td>
        <td>${admin.aLevel}</td>
    </tr>
</c:forEach>
<%=request.getAttribute("admin")%>
</body>
</html>
