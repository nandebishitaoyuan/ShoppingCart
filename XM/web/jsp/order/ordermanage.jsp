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
    <title>订单管理</title>
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
        form table tr td{
            border: 0px solid;
        }
    </style>
</head>
<body>
<table>
    <tr>
        <td>订单编号</td>
        <td>订单时间</td>
        <td>管理员编号</td>
        <td>发货状态</td>
        <td>类别</td>
        <td>地址</td>
        <td>电话</td>
        <td>用户编号</td>
        <td>价格</td>
    </tr>

    <c:forEach items="${requestScope.orders}" var="orders">
    <tr>
        <td>
            <p>${orders.oId}</p>
        </td>
        <td>
            <p>${orders.oDate}</p>
        </td>
        <td>
            <p>${orders.aId}</p>
        </td>
        <td>
            <p>${orders.oState}</p>
        </td>
        <td>
            <p>${orders.oRecname}</p>
        </td>
        <td>
            <p>${orders.oRecadr}</p>
        </td>
        <td>
            <p>${orders.oRectel}</p>
        </td>
        <td>
            <p>${orders.uId}</p>
        </td>
        <td>
            <p>${orders.ototalprice}</p>
        </td>
    </tr>
    </c:forEach>
</table>
<form action="/hello/SearchOrder" method="get">
    <table>
        <tr>
            <td>在此搜索需要修改的订单号</td>
            <td><input type="text" name="orderID"></td>
            <td><input type="submit" value="搜索"></td>
        </tr>
    </table>
</form>
</body>
</html>
