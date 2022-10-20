<%--
  Created by IntelliJ IDEA.
  User: Sky
  Date: 2022/10/19
  Time: 22:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>订单修改</title>
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
  </style>
</head>
<body>
<form action="/hello/UpdateOrderState" method="post">
  <table>
    <thead>搜索到该订单信息如下</thead>
    <c:forEach items="${requestScope.order}" var="order">
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
        <td>发货状态修改</td>
        <td>是否确认修改</td>
      </tr>
      <tr>
        <td>
          <p>${order.oId}</p>
        </td>
        <td>
          <p>${order.oDate}</p>
        </td>
        <td>
          <p>${order.aId}</p>
        </td>
        <td>
          <p>${order.oState}</p>
        </td>
        <td>
          <p>${order.oRecname}</p>
        </td>
        <td>
          <p>${order.oRecadr}</p>
        </td>
        <td>
          <p>${order.oRectel}</p>
        </td>
        <td>
          <p>${order.uId}</p>
        </td>
        <td>
          <p>${order.ototalprice}</p>
        </td>
        <td>
          <input type="hidden" name="oid" value="${order.oId}">
          <c:if test="${order.oState == '已发货'}">
            <input type="checkbox" name="state" value="未发货">未发货
          </c:if>
          <c:if test="${order.oState == '未发货'}">
            <input type="checkbox" name="state" value="已发货">已发货
          </c:if>
        </td>
        <td>
          <input type="submit" value="提交">
        </td>
      </tr>
    </c:forEach>
  </table>
</form>
</body>
</html>
