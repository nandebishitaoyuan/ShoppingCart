package com.Javaone.service.impl;

import com.Javaone.dao.IGoodsInfoDao;
import com.Javaone.dao.impl.IGoodsInfoDaoImpl;
import com.Javaone.pojo.GoodsInfo;
import com.Javaone.service.GoodsService;
import com.Javaone.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodsServiceImpl implements GoodsService {
    private IGoodsInfoDao goodsInfo = new IGoodsInfoDaoImpl();

    @Override
    public List getgClassInfo() throws SQLException {
        DBUtil dbUtil = new DBUtil();
        String sql = "SELECT DISTINCT Gclass from goodsinfo";
        ResultSet result = dbUtil.getQueryResult(sql, null);
        List list = new ArrayList();
        while (result.next()) {
            list.add(result.getString("Gclass"));
        }
        return list;
    }

    @Override
    public List<GoodsInfo> allGoods() throws SQLException {
        return goodsInfo.getGoodsInfoList();
    }

    @Override
    public List<GoodsInfo> getGoodsLike(String name) throws SQLException {
        GoodsInfo info = new GoodsInfo();
        info.setgName(name);
        if (goodsInfo instanceof IGoodsInfoDaoImpl){
            return ((IGoodsInfoDaoImpl)goodsInfo).getGoodsInfoList(info);
        }else {
            return null;
        }
    }

    @Override
    public Boolean updateGoodsInfo(GoodsInfo goods) throws SQLException {
        return goodsInfo.UpdateGoodsInfo(goods) > 0;
    }
}
