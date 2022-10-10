package com.Javaone.dao.impl;

import com.Javaone.dao.impl.IOrderInfoDaoImpl;
import com.Javaone.pojo.OrderInfo;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class OrderInfoTest {
    //全查
    @Test
    public void testOrderInfoQuery() throws Exception {
        IOrderInfoDaoImpl dao = new IOrderInfoDaoImpl();
        List<OrderInfo> orderInfoList = dao.getOrderInfoList();
        for (OrderInfo orderInfo : orderInfoList) {
            System.out.println(orderInfo);
        }
    }
    //条件查
    @Test
    public void testOrderInfoConQuery() throws Exception {
        IOrderInfoDaoImpl dao = new IOrderInfoDaoImpl();
        OrderInfo order = new OrderInfo();
        //order.setuId(10003);
        order.setoId(4);
        List<OrderInfo> orderInfoList = dao.getOrderInfoList(order);
        for (OrderInfo orderInfo : orderInfoList) {
            System.out.println(orderInfo);
        }
    }
    //添加
    @Test
    public void testAddOrder() throws Exception {
        IOrderInfoDaoImpl dao = new IOrderInfoDaoImpl();
        OrderInfo order = new OrderInfo(5,new Date(),10004,"已发货","测试","四川科技职业学院","123",10003,520.0);
        dao.AddOrderInfo(order);
        testOrderInfoQuery();
    }
    //修改
    @Test
    public void testUpdateOrder() throws Exception {
        IOrderInfoDaoImpl dao = new IOrderInfoDaoImpl();
        //OrderInfo order = new OrderInfo(5,new Date(),10004,"未发货","测试","四川科技职业学院","456",10003,520.0);
        OrderInfo order1 = new OrderInfo();
        order1.setoId(5);
        order1.setoState("你猜发没发货!");
        if (dao.UpdateOrderInfo(order1)!=0){
            System.out.println("修改成功！");
            testOrderInfoQuery();
        }else {
            System.out.println("修改失败！");
        }
    }
    //删除
    @Test
    public void testDeleteOrder() throws Exception {
        IOrderInfoDaoImpl dao = new IOrderInfoDaoImpl();
        dao.DeleteOrderInfo(5);
        testOrderInfoQuery();
    }
}
