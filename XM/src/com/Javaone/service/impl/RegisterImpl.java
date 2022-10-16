package com.Javaone.service.impl;

import com.Javaone.dao.IUserInfo;
import com.Javaone.dao.impl.IUserInfoImpl;
import com.Javaone.pojo.UserInfo;
import com.Javaone.service.Register;

import java.sql.SQLException;

public class RegisterImpl implements Register {
    //用户注册
    @Override
    public Boolean register(String name, String pwd, String email) throws SQLException {
        IUserInfo userInfo = new IUserInfoImpl();
        UserInfo user = new UserInfo(null, name, pwd, email);
        return userInfo.AddUserInfo(user) > 0;
    }
}
