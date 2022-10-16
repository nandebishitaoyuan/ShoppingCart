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
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="../../css/change.css">
</head>
<body>
<div class="control">
    <div class="item1">
        <div class="active">管理员登录</div>
    </div>
    <form action="/hello/admin" method="post">
        <div class="content">
            <div style="display: block;">
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
            </div>
        </div>
    </form>
</div>
${requestScope.login}
</body>
</html>
