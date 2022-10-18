<%--
  Created by IntelliJ IDEA.
  User: Sky
  Date: 2022/10/18
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>删除管理员</title>
</head>
<body>
<form action="/hello/Search1" method="get">
    <table>
        <tr>
            <td>请输入管理员名称</td>
            <td><input type="text" name="name"></td>
            <td><input type="submit" value="搜索"></td>
        </tr>
    </table>
</form>
<c:forEach items="${requestScope.adminList}" var="adminList">
    <form action="/hello/DeletAdminServlet" method="get">
        <table>
            <tr>
                <td>管理员编号</td>
                <td>管理员名称</td>
                <td>管理员权限</td>
            </tr>
            <tr>
                <td>${adminList.aid}</td>
                <td>${adminList.aName}</td>
                <td>${adminList.aLevel}</td>
            </tr>
            <tr>
                <td><input type="hidden" name="id" value="${adminList.aid}"></td>
            </tr>
            <tr>
                <td>确定要删除该管理员吗？</td>
            </tr>
            <tr>
                <td><input type="submit" name="yes" value="确定"></td>
                <td><input type="submit" name="yes" value="取消"></td>
            </tr>
        </table>
    </form>
</c:forEach>
</body>
</html>
