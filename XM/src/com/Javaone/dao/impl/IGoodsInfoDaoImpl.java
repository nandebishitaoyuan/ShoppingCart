package com.Javaone.dao.impl;

import com.Javaone.dao.IGoodsInfoDao;
import com.Javaone.pojo.GoodsInfo;
import com.Javaone.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IGoodsInfoDaoImpl implements IGoodsInfoDao {
    private DBUtil dbUtil = new DBUtil();

    //全部查询
    @Override
    public List<GoodsInfo> getGoodsInfoList() throws SQLException {
        ResultSet queryResult = dbUtil.getQueryResult("select * from goodsinfo",null);
        List<GoodsInfo> GoodsInfoList = new ArrayList<>();
        while (queryResult.next()) {
            GoodsInfo goods = new GoodsInfo();
            goods.setgId(queryResult.getInt("Gid"));
            goods.setgName(queryResult.getString("Gname"));
            goods.setgPrice(queryResult.getDouble("Gprice"));
            goods.setgClass(queryResult.getString("Gclass"));
            goods.setgAmount(queryResult.getInt("Gamount"));
            goods.setgDate(queryResult.getDate("Gdate"));
            goods.setgImgurl(queryResult.getString("Gimgurl"));
            goods.sethLook(queryResult.getInt("Glook"));
            goods.setgBrief(queryResult.getString("Gbrief"));
            GoodsInfoList.add(goods);
        }
        dbUtil.closeConn();
        return GoodsInfoList;
    }
    //条件查询
    public List<GoodsInfo> getGoodsInfoList(GoodsInfo goodsInfo) throws SQLException{
        StringBuffer sql = new StringBuffer(80);
        List params = new ArrayList();
        sql.append("SELECT * FROM goodsinfo where 1=1 ");
        if (goodsInfo.getgId()!=null){
            sql.append(" and Gid=?");
            params.add(goodsInfo.getgId());
        }
        if (goodsInfo.getgName()!=null){
            sql.append(" and Gname=?");
            params.add(goodsInfo.getgName());
        }
        if (goodsInfo.getgPrice()!=null){
            sql.append(" and Gprice=?");
            params.add(goodsInfo.getgPrice());
        }
        if (goodsInfo.getgClass()!=null){
            sql.append(" and Gclass=?");
            params.add(goodsInfo.getgClass());
        }
        if (goodsInfo.getgAmount()!=null){
            sql.append(" and Gamount=?");
            params.add(goodsInfo.getgAmount());
        }
        if (goodsInfo.getgDate()!=null){
            sql.append(" and Gdate=?");
            params.add(goodsInfo.getgDate());
        }
        if (goodsInfo.getgImgurl()!=null){
            sql.append(" and Gimgurl=?");
            params.add(goodsInfo.getgImgurl());
        }
        if (goodsInfo.gethLook()!=null){
            sql.append(" and Glook=?");
            params.add(goodsInfo.gethLook());
        }
        if (goodsInfo.getgIntro()!=null){
            sql.append(" and Gintro=?");
            params.add(goodsInfo.getgIntro());
        }
        if (goodsInfo.getgBrief()!=null){
            sql.append(" and Gbrief=?");
            params.add(goodsInfo.getgBrief());
        }
        ResultSet queryResult = dbUtil.getQueryResult(sql.toString(), params);
        List<GoodsInfo> GoodsInfoList = new ArrayList<>();
        while (queryResult.next()) {
            GoodsInfo goods = new GoodsInfo();
            goods.setgId(queryResult.getInt("Gid"));
            goods.setgName(queryResult.getString("Gname"));
            goods.setgPrice(queryResult.getDouble("Gprice"));
            goods.setgClass(queryResult.getString("Gclass"));
            goods.setgAmount(queryResult.getInt("Gamount"));
            goods.setgDate(queryResult.getDate("Gdate"));
            goods.setgImgurl(queryResult.getString("Gimgurl"));
            goods.sethLook(queryResult.getInt("Glook"));
            goods.setgBrief(queryResult.getString("Gbrief"));
            GoodsInfoList.add(goods);
        }
        dbUtil.closeConn();
        return GoodsInfoList;
    }

    //添加
    @Override
    public int AddGoodsInfo(GoodsInfo goods) {
        String sql = "insert into goodsinfo(Gid,Gname,Gprice,Gclass,Gamount,Gdate,Gimgurl,Glook,Gintro,Gbrief) values(?,?,?,?,?,?,?,?,?,?)";
        List params = new ArrayList();
        params.add(goods.getgId());
        params.add(goods.getgName());
        params.add(goods.getgPrice());
        params.add(goods.getgClass());
        params.add(goods.getgAmount());
        params.add(goods.getgDate());
        params.add(goods.getgImgurl());
        params.add(goods.gethLook());
        params.add(goods.getgIntro());
        params.add(goods.getgBrief());
        return dbUtil.Update(sql,params);
    }

    //修改
    @Override
    public int UpdateGoodsInfo(GoodsInfo goods) {
        List params = new ArrayList<>();
        String sql = "UPDATE goodsinfo SET ";
        if (goods.getgName()!=null) {
            sql+="Gname=?";
            params.add(goods.getgName());
        }
        if (goods.getgPrice()!=null) {
            if (params.size()>0) {
                sql+=",";
            }
            sql+="Gprice=?";
            params.add(goods.getgPrice());
        }
        if (goods.getgClass()!=null) {
            if (params.size()>0) {
                sql+=",";
            }
            sql+="Gclass=?";
            params.add(goods.getgClass());
        }
        if (goods.getgAmount()!=null) {
            if (params.size()>0) {
                sql+=",";
            }
            sql+="Gamount=?";
            params.add(goods.getgAmount());
        }
        if (goods.getgDate()!=null) {
            if (params.size()>0) {
                sql+=",";
            }
            sql+="Gdate=?";
            params.add(goods.getgDate());
        }
        if (goods.getgImgurl()!=null) {
            if (params.size()>0) {
                sql+=",";
            }
            sql+="Gimgurl=?";
            params.add(goods.getgImgurl());
        }
        if (goods.gethLook()!=null) {
            if (params.size()>0) {
                sql+=",";
            }
            sql+="Glook=?";
            params.add(goods.gethLook());
        }
        if (goods.getgIntro()!=null) {
            if (params.size()>0) {
                sql+=",";
            }
            sql+="Gintro=?";
            params.add(goods.getgIntro());
        }
        if (goods.getgBrief()!=null) {
            if (params.size()>0) {
                sql+=",";
            }
            sql+="Gbrief=?";
            params.add(goods.getgBrief());
        }
        if (goods.getgId()==null) {
            return 0;
        }else {
            sql+=" where Gid=?";
            params.add(goods.getgId());
        }
        return dbUtil.Update(sql, params);
    }
    //删除
    @Override
    public int DeleteGoodsInfo(int id) {
        String sql = "delete from goodsinfo where Gid=?";
        List params = new ArrayList();
        params.add(id);
        return dbUtil.Update(sql,params);
    }
}
