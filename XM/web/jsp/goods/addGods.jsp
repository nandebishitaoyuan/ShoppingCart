<%--
  Created by IntelliJ IDEA.
  User: Sky
  Date: 2022/10/20
  Time: 17:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增商品</title>
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
<form action="/hello/UpdateGoodsInfoServlet" method="post">
    <table>
        <tr>
            <td>商品图片</td>
            <td>商品名称</td>
            <td>商品价格</td>
            <td>商品类别</td>
            <td>库存数量</td>
            <td>作者</td>
            <td>简介</td>
        </tr>
        <tr>
            <td>
                <input type="text" name="gImgurl">
            </td>
            <td>
                <input type="text" name="gName">
            </td>
            <td>
                <input type="text" name="gPrice">
            </td>
            <td>
                <input type="text" name="gClass">
            </td>
            <td>
                <input type="hidden" name="gAmount" value="0">
                <input type="text" name="hLook">
            </td>
            <td>
                <textarea name="gIntro" rows="5"></textarea>
            </td>
            <td>
                <textarea name="gBrief" rows="5"></textarea>
            </td>
        </tr>
        <tr>
            <td colspan="10">
                <input name="add" value="add" type="hidden">
                <input type="submit" value="提交">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
