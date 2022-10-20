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
    <title>商品管理</title>
    <style>
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
    </style>
</head>
<body>
<div>
    <table>
        <thead><h1>所有商品</h1></thead>
        <tr>
            <td>商品编号</td>
            <td>商品图片</td>
            <td>商品名称</td>
            <td>商品价格</td>
            <td>商品类别</td>
            <td>库存数量</td>
            <td>入库时间</td>
            <td>购买人数</td>
            <td>作者</td>
            <td>简介</td>
        </tr>
        <c:forEach items="${requestScope.goods}" var="goods">
            <tr>
                <td>
                    <p>${goods.gId}</p>
                </td>
                <td>
                    <img src="/hello/${goods.gImgurl}" height="75px" width="50px">
                </td>
                <td>
                    <p>${goods.gName}</p>
                </td>
                <td>
                    <p>${goods.gPrice}</p>
                </td>
                <td>
                    <p>${goods.gClass}</p>
                </td>
                <td>
                    <p>${goods.gAmount}</p>
                </td>
                <td>
                    <p>${goods.gDate}</p>
                </td>
                <td>
                    <p>${goods.hLook}</p>
                </td>
                <td>
                    <p>${goods.gIntro}</p>
                </td>
                <td>
                    <p>${goods.gBrief}</p>
                </td>
            </tr>
        </c:forEach>
    </table>
    <form action="/hello/search" method="get">
        <table>
            <tr>
                <td>在此搜索需要修改的商品名称</td>
                <td><input type="text" name="gName"></td>
                <td><input type="submit" value="搜索"></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
