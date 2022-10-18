<%--
  Created by IntelliJ IDEA.
  User: Sky
  Date: 2022/10/18
  Time: 9:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加管理员</title>
</head>
<body>
    <form action="/hello/addAdminServlet" method="post">
        <table>
            <tr>
                <td>管理员名称</td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td>管理员密码</td>
                <td><input type="password" name="pwd"></td>
            </tr>
            <tr>
                <td>管理员权限</td>
                <td><select name="level">
                    <option value="普通">普通</option>
                    <option value="超级">超级</option>
                </select></td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="添加">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
