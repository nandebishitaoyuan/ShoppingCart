package com.Javaone.dao;

import com.Javaone.pojo.AdminInfo;

import java.sql.SQLException;
import java.util.List;

public interface IAdminInfoDao {
    //查
    public List<AdminInfo> getAdminInfoList() throws SQLException;
    //增
    public int AddAdminInfo(AdminInfo admin) throws SQLException;
    //改
    public int UpdateAdminInfo(AdminInfo admin) throws SQLException;
    //删
    public int DeleteAdminInfo(int id) throws SQLException;
}
