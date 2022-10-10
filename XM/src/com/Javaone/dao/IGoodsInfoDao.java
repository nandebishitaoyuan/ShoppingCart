package com.Javaone.dao;

import com.Javaone.pojo.GoodsInfo;

import java.sql.SQLException;
import java.util.List;

public interface IGoodsInfoDao {
    //查
    public List<GoodsInfo> getGoodsInfoList() throws SQLException;
    //增
    public int AddGoodsInfo(GoodsInfo goods) throws SQLException;
    //改
    public int UpdateGoodsInfo(GoodsInfo goods) throws SQLException;
    //删
    public int DeleteGoodsInfo(int id) throws SQLException;
}
