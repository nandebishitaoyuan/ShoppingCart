package com.Javaone.dao;

import com.Javaone.pojo.UserInfo;

import java.sql.SQLException;
import java.util.List;

public interface IUserInfo {
    //查
    public List<UserInfo> getUserInfoList() throws SQLException;
    //增
    public int AddUserInfo(UserInfo user) throws SQLException;
    //改
    public int UpdateUserInfo(UserInfo user) throws SQLException;
    //删
    public int DeleteUserInfo(int id) throws SQLException;
}
