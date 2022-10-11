<%--
  Created by IntelliJ IDEA.
  User: Sky
  Date: 2022/10/11
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>denglu</title>
</head>
<body>
<form action="/hello/test" method="get">
    <input type="submit" value="测试">
</form>
<%= request.getAttribute("test")%>
${requestScope.test}
</body>
</html>
