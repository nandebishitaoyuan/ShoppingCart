package com.Javaone.service;

import java.sql.SQLException;

public interface IsLogin {
    //管理员登录
    Boolean AdminLogin(String name, String pwd) throws SQLException;
    //用户登录
    Boolean UserLogin(String name, String pwd) throws SQLException;
}
