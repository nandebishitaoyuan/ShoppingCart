package com.Javaone.service;

import java.sql.SQLException;
import java.util.List;

public interface OrderService {
    /**
     * 查询全部订单
     * @return
     * @throws SQLException
     */
    List allOrders() throws SQLException;

    /**
     * 修改订单发货状态
     * @param oid
     * @return
     * @throws SQLException
     */
    Boolean updateOrder(Integer oid, String state) throws SQLException;

    /**
     * 通过订单号查询订单信息
     * @param oid
     * @return
     * @throws SQLException
     */
    List getOrder(Integer oid) throws SQLException;


}
