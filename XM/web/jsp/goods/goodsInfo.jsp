<%--
  Created by IntelliJ IDEA.
  User: Sky
  Date: 2022/10/18
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>商品修改</title>
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
            <td colspan="10"><h2>修改前的信息</h2></td>
        </tr>
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
            <td>商品状态</td>
        </tr>
        <c:forEach items="${requestScope.gList}" var="goods">
            <tr>
                <td>
                    <p>${goods.gId}</p>
                </td>
                <td>
                    <p>${goods.gImgurl}</p>
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
                <td>
                    <p>正常</p>
                </td>
            </tr>
            <tr>
                <td colspan="10"><h2>修改后的信息</h2></td>
            </tr>
            <tr>
                <td>
                    <p>商品编号禁止修改</p>
                    <input type="hidden" name="gId" value="${goods.gId}">
                </td>
                <td>
                    <input type="text" name="gImgurl" value="${goods.gImgurl}">
                </td>
                <td>
                    <input type="text" name="gName" value="${goods.gName}">
                </td>
                <td>
                    <input type="text" name="gPrice" value="${goods.gPrice}">
                </td>
                <td>
                    <input type="text" name="gClass" value="${goods.gClass}">
                </td>
                <td>
                    <input type="text" name="gAmount" value="${goods.gAmount}">
                </td>
                <td>
                    <input type="text" name="gDate" value="${goods.gDate}">
                </td>
                <td>
                    <input type="text" name="hLook" value="${goods.hLook}">
                </td>
                <td>
                    <textarea name="gIntro" rows="5">${goods.gIntro}</textarea>
                </td>
                <td>
                    <textarea name="gBrief" rows="5">${goods.gBrief}</textarea>
                </td>
                <td>
                    <input type="checkbox" name="del" value="del">删除该商品
                </td>
            </tr>
            <tr>
                <td colspan="10">
                    <input type="submit" value="提交">
                </td>
            </tr>
        </c:forEach>
    </table>
</form>
</body>
</html>
