<%--
  Created by IntelliJ IDEA.
  User: Sky
  Date: 2022/10/18
  Time: 9:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>修改管理员信息</title>
</head>
<body>
    <form action="/hello/Search" method="get">
        <table>
            <tr>
                <td>请输入管理员名称</td>
                <td><input type="text" name="name"></td>
                <td><input type="submit" value="搜索"></td>
            </tr>
        </table>
    </form>
    <c:forEach items="${requestScope.adminList}" var="adminList">
        <form action="/hello/updateAdminServlet" method="post">
            <table>
                <tr>
                    <td><input type="hidden" name="id" value="${adminList.aid}"></td>
                </tr>
                <tr>
                    <td>管理员名称&nbsp</td>
                    <td><input type="text" name="name" value="${adminList.aName}"></td>
                </tr>
                <tr>
                    <td>管理员密码&nbsp</td>
                    <td><input type="password" name="pwd" value="${adminList.aPwd}"></td>
                </tr>
                <tr>
                    <td>管理员权限&nbsp</td>
                    <td><input type="text" name="level" value="${adminList.aLevel}"></td>
                </tr>
                <tr>
                    <td><input type="submit" value="提交"></td>
                </tr>
            </table>
        </form>
    </c:forEach>
</body>
</html>
