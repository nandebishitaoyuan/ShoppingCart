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
<form action="/hello/test" method="post">
    <table align="center">
        <tr>
            <td colspan="2" align="center"><h1>管理员登录</h1></td>
        </tr>
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" name="pwd"></td>
        </tr>
        <tr>
            <br/><td colspan="2" align="center"><input type="submit" value="登录"></td>
        </tr>
    </table>
</form>
${requestScope.login}
</body>
</html>
