package com.Javaone.service.impl;

import com.Javaone.dao.IAdminInfoDao;
import com.Javaone.dao.IUserInfo;
import com.Javaone.dao.impl.IAdminInfoDaoImpl;
import com.Javaone.dao.impl.IUserInfoImpl;
import com.Javaone.pojo.AdminInfo;
import com.Javaone.pojo.UserInfo;
import com.Javaone.service.Register;

import java.sql.SQLException;

public class RegisterImpl implements Register {
    //用户注册
    @Override
    public Boolean userRegister(String name, String pwd, String email) throws SQLException {
        IUserInfo userInfo = new IUserInfoImpl();
        UserInfo user = new UserInfo(null, name, pwd, email);
        return userInfo.AddUserInfo(user) > 0;
    }

    @Override
    public Boolean adminRegister(String name, String pwd, String level) throws SQLException {
        IAdminInfoDao adminInfo = new IAdminInfoDaoImpl();
        AdminInfo admin = new AdminInfo(null, name, pwd, level);
        return adminInfo.AddAdminInfo(admin) > 0;
    }
}
