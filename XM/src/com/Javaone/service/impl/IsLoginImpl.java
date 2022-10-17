package com.Javaone.service.impl;

import com.Javaone.dao.impl.IAdminInfoDaoImpl;
import com.Javaone.dao.impl.IUserInfoImpl;
import com.Javaone.pojo.AdminInfo;
import com.Javaone.pojo.UserInfo;
import com.Javaone.service.IsLogin;

import java.sql.SQLException;
import java.util.List;

public class IsLoginImpl implements IsLogin {
    //管理员登录
    @Override
    public Boolean AdminLogin(String name, String pwd) throws SQLException {
        IAdminInfoDaoImpl dao = new IAdminInfoDaoImpl();
        AdminInfo admin = new AdminInfo();
        admin.setaName(name);
        admin.setaPwd(pwd);
        List<AdminInfo> adminInfoList = dao.getAdminInfoList(admin);
        if (adminInfoList != null && adminInfoList.size() > 0) {
            return true;
        }else return false;
    }
    //用户登录
    @Override
    public Boolean UserLogin(String name, String pwd) throws SQLException {
        IUserInfoImpl dao = new IUserInfoImpl();
        UserInfo user = new UserInfo();
        user.setuName(name);
        user.setuPwd(pwd);
        List<UserInfo> userInfoList = dao.getUserInfoList(user);
        if (userInfoList != null && userInfoList.size() > 0)
            return true;
        else return false;
    }
}
