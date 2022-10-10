package com.Javaone.dao;

import com.Javaone.pojo.OrderInfo;

import java.sql.SQLException;
import java.util.List;

public interface IOrderInfoDao {
    //查
    public List<OrderInfo> getOrderInfoList() throws SQLException;
    //增
    public int AddOrderInfo(OrderInfo order) throws SQLException;
    //改
    public int UpdateOrderInfo(OrderInfo order) throws SQLException;
    //删
    public int DeleteOrderInfo(int id) throws SQLException;
}
