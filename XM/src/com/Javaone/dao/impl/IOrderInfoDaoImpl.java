package com.Javaone.dao.impl;

import com.Javaone.dao.IOrderInfoDao;
import com.Javaone.pojo.OrderInfo;
import com.Javaone.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IOrderInfoDaoImpl implements IOrderInfoDao {
    DBUtil dbUtil = new DBUtil();

    //全部查询
    @Override
    public List<OrderInfo> getOrderInfoList() throws SQLException {
        ResultSet queryResult = dbUtil.getQueryResult("select * from orderinfo", null);
        List<OrderInfo> orderInfoList = new ArrayList<>();
        while (queryResult.next()) {
            OrderInfo orderInfo = new OrderInfo();
            orderInfo.setoId(queryResult.getInt("Oid"));
            orderInfo.setaId(queryResult.getInt("AId"));
            orderInfo.setoDate(queryResult.getDate("Odate"));
            orderInfo.setoState(queryResult.getString("Ostate"));
            orderInfo.setoRecname(queryResult.getString("Orecname"));
            orderInfo.setoRecadr(queryResult.getString("Orecadr"));
            orderInfo.setoRectel(queryResult.getString("Orectel"));
            orderInfo.setuId(queryResult.getInt("Uid"));
            orderInfo.setOtotalprice(queryResult.getDouble("Ototalprice"));
            orderInfoList.add(orderInfo);
        }
        dbUtil.closeConn();
        return orderInfoList;
    }

    //条件查询
    public List<OrderInfo> getOrderInfoList(OrderInfo order) throws SQLException {
        StringBuffer sql = new StringBuffer(80);
        List params = new ArrayList();
        sql.append("SELECT * FROM orderinfo where 1=1 ");
        if (order.getoId()!=null){
            sql.append(" and Oid=?");
            params.add(order.getoId());
        }
        if (order.getaId()!=null){
            sql.append(" and AId=?");
            params.add(order.getaId());
        }
        if (order.getoDate()!=null){
            sql.append(" and Odate=?");
            params.add(order.getoDate());
        }
        if (order.getoState()!=null){
            sql.append(" and Ostate=?");
            params.add(order.getoState());
        }
        if (order.getoRecname()!=null){
            sql.append(" and Orecname=?");
            params.add(order.getoRecname());
        }
        if (order.getoRecadr()!=null){
            sql.append(" and Orecadr=?");
            params.add(order.getoRecadr());
        }
        if (order.getoRectel()!=null){
            sql.append(" and Orectel=?");
            params.add(order.getoRectel());
        }
        if (order.getuId()!=null){
            sql.append(" and Ototalprice=?");
            params.add(order.getuId());
        }
        params.add(order.getOtotalprice());
        ResultSet queryResult = dbUtil.getQueryResult(sql.toString(), params);
        List<OrderInfo> orderInfoList = new ArrayList<>();
        while (queryResult.next()) {
            OrderInfo orderInfo = new OrderInfo();
            orderInfo.setoId(queryResult.getInt("Oid"));
            orderInfo.setaId(queryResult.getInt("AId"));
            orderInfo.setoDate(queryResult.getDate("Odate"));
            orderInfo.setoState(queryResult.getString("Ostate"));
            orderInfo.setoRecname(queryResult.getString("Orecname"));
            orderInfo.setoRecadr(queryResult.getString("Orecadr"));
            orderInfo.setoRectel(queryResult.getString("Orectel"));
            orderInfo.setuId(queryResult.getInt("Uid"));
            orderInfo.setOtotalprice(queryResult.getDouble("Ototalprice"));
            orderInfoList.add(orderInfo);
        }
        dbUtil.closeConn();
        return orderInfoList;
    }

    //添加
    @Override
    public int AddOrderInfo(OrderInfo order) {
        String sql = "insert into orderinfo(Oid,AId,Odate,Ostate,Orecname,Orecadr,Orectel,Uid,Ototalprice) values(?,?,?,?,?,?,?,?,?)";
        List params = new ArrayList<>();
        params.add(order.getoId());
        params.add(order.getaId());
        params.add(order.getoDate());
        params.add(order.getoState());
        params.add(order.getoRecname());
        params.add(order.getoRecadr());
        params.add(order.getoRectel());
        params.add(order.getuId());
        params.add(order.getOtotalprice());
        return dbUtil.Update(sql, params);
    }
    //修改
    @Override
    public int UpdateOrderInfo(OrderInfo order) {
        List params = new ArrayList<>();
        String sql = "UPDATE orderinfo SET ";
        if (order.getaId()!=null) {
            sql+="AId=?";
            params.add(order.getaId());
        }
        if (order.getoDate()!=null) {
            if (params.size()>0) {
                sql+=",";
            }
            sql+="Odate=?";
            params.add(order.getoDate());
        }
        if (order.getoState()!=null) {
            if (params.size()>0) {
                sql+=",";
            }
            sql+="Ostate=?";
            params.add(order.getoState());
        }
        if (order.getoRecname()!=null) {
            if (params.size()>0) {
                sql+=",";
            }
            sql+="Orecname=?";
            params.add(order.getoRecname());
        }
        if (order.getoRecadr()!=null) {
            if (params.size()>0) {
                sql+=",";
            }
            sql+="Orecadr=?";
            params.add(order.getoRecadr());
        }
        if (order.getoRectel()!=null) {
            if (params.size()>0) {
                sql+=",";
            }
            sql+="Orectel=?";
            params.add(order.getoRectel());
        }
        if (order.getuId()!=null) {
            if (params.size()>0) {
                sql+=",";
            }
            sql+="Uid=?";
            params.add(order.getuId());
        }
        if (order.getOtotalprice()!=null) {
            if (params.size()>0) {
                sql+=",";
            }
            sql+="Ototalprice=?";
            params.add(order.getOtotalprice());
        }
        if (order.getoId()==null) {
            return 0;
        }else {
            sql+=" where Oid=?";
            params.add(order.getoId());
        }
        return dbUtil.Update(sql, params);
    }
    //删除
    @Override
    public int DeleteOrderInfo(int id) {
        String sql = "delete from orderinfo where Oid=?";
        List<Integer> params = new ArrayList<>();
        params.add(id);
        return dbUtil.Update(sql,params);
    }
}
