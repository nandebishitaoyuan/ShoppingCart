package com.Javaone.service.impl;

import com.Javaone.dao.IOrderInfoDao;
import com.Javaone.dao.impl.IOrderInfoDaoImpl;
import com.Javaone.pojo.OrderInfo;
import com.Javaone.service.OrderService;
import com.Javaone.util.DBUtil;

import java.sql.SQLException;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    private IOrderInfoDaoImpl dao = new IOrderInfoDaoImpl();
    @Override
    public List allOrders() throws SQLException {
        return dao.getOrderInfoList();
    }

    @Override
    public Boolean updateOrder(Integer oid, String state) throws SQLException {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setoState(state);
        orderInfo.setoId(oid);
        return dao.UpdateOrderInfo(orderInfo) > 0;
    }

    @Override
    public List getOrder(Integer oid) throws SQLException {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setoId(oid);
        return dao.getOrderInfoList(orderInfo);
    }
}
