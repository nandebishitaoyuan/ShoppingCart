package com.Javaone.dao.impl;

import com.Javaone.dao.IAdminInfoDao;
import com.Javaone.pojo.AdminInfo;
import com.Javaone.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IAdminInfoDaoImpl implements IAdminInfoDao {
    DBUtil dbUtil = new DBUtil();
    //查询
    @Override
    public List<AdminInfo> getAdminInfoList() throws SQLException {
        ResultSet queryResult = dbUtil.getQueryResult("select * from admininfo",null);
        List<AdminInfo> adminInfoList = new ArrayList<>();
        while (queryResult.next()) {
            AdminInfo admin = new AdminInfo();
            admin.setAid(queryResult.getInt("Aid"));
            admin.setaName(queryResult.getString("Aname"));
            admin.setaPwd(queryResult.getString("Apwd"));
            admin.setaLevel(queryResult.getString("Alevel"));
            adminInfoList.add(admin);
        }
        dbUtil.closeConn();
        return adminInfoList;
    }
    //条件查询
    public List<AdminInfo> getAdminInfoList(AdminInfo adminInfo) throws SQLException {
        StringBuffer sql = new StringBuffer(80);
        List list = new ArrayList();
        sql.append("SELECT * FROM admininfo where 1=1 ");
        if (adminInfo.getAid()!=null){
            sql.append(" and Aid=?");
            list.add(adminInfo.getAid());
        }
        if (adminInfo.getaName()!=null){
            sql.append(" and Aname=?");
            list.add(adminInfo.getaName());
        }
        if (adminInfo.getaPwd()!=null){
            sql.append(" and Apwd=?");
            list.add(adminInfo.getaPwd());
        }
        if (adminInfo.getaLevel()!=null){
            sql.append(" and Alevel=?");
            list.add(adminInfo.getaLevel());
        }
        ResultSet result = dbUtil.getQueryResult(sql.toString(), list);
        List<AdminInfo> adminInfoList = new ArrayList<>();
        while (result.next()) {
            AdminInfo admin = new AdminInfo();
            admin.setAid(result.getInt("Aid"));
            admin.setaName(result.getString("Aname"));
            admin.setaPwd(result.getString("Apwd"));
            admin.setaLevel(result.getString("Alevel"));
            adminInfoList.add(admin);
        }
        dbUtil.closeConn();
        return adminInfoList;
    }
    //添加
    @Override
    public int AddAdminInfo(AdminInfo admin) {
        String sql = "insert into admininfo(aid,aname,apwd,alevel) values(?,?,?,?)";
        List params = new ArrayList();
        params.add(admin.getAid());
        params.add(admin.getaName());
        params.add(admin.getaPwd());
        params.add(admin.getaLevel());
        return dbUtil.Update(sql,params);
    }
    //修改
    @Override
    public int UpdateAdminInfo(AdminInfo admin) {
        List params = new ArrayList<>();
        String sql = "UPDATE admininfo SET ";
        if (admin.getaName()!=null) {
            sql+="Aname=?";
            params.add(admin.getaName());
        }
        if (admin.getaPwd()!=null) {
            if (params.size()>0) {
                sql+=",";
            }
            sql+="Apwd=?";
            params.add(admin.getaPwd());
        }
        if (admin.getaLevel()!=null) {
            if (params.size()>0) {
                sql+=",";
            }
            sql+="Alevel=?";
            params.add(admin.getaLevel());
        }
        if (admin.getAid()==null) {
            return 0;
        }else {
            sql+=" where Aid=?";
            params.add(admin.getAid());
        }
        return dbUtil.Update(sql, params);
    }
    //删除
    @Override
    public int DeleteAdminInfo(int id) {
        String sql = "delete from admininfo where Aid=?";
        List params = new ArrayList();
        params.add(id);
        return dbUtil.Update(sql,params);
    }
}
