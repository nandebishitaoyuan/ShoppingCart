package com.Javaone.service;

import com.Javaone.pojo.GoodsInfo;

import java.sql.SQLException;
import java.util.List;

public interface GoodsService {
    /**
     * 获取所有商品类别
     * @return 返回所有商品类别
     * @throws SQLException
     */
    List getgClassInfo() throws SQLException;

    /**
     * 获取所有商品信息
     * @return  返回所有商品的信息
     * @throws SQLException
     */
    List<GoodsInfo> allGoods() throws SQLException;

    /**
     * 查找商品
     * @return 返回该商品的信息
     * @throws SQLException
     */
    List<GoodsInfo> getGoodsLike(String name) throws SQLException;

    /**
     * 修改商品信息
     * @param goodsInfo
     * @return
     * @throws SQLException
     */
    Boolean updateGoodsInfo(GoodsInfo goodsInfo) throws SQLException;

    /**
     * 删除商品
     * @param id
     * @return
     * @throws SQLException
     */
    Boolean delGoods(Integer id) throws SQLException;

    /**
     * 添加商品
     * @param goodsInfo
     * @return
     * @throws SQLException
     */
    Boolean addGoods(GoodsInfo goods) throws SQLException;
}
