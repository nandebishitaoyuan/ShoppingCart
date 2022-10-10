package com.Javaone.service;

public interface IsLogin {
    //管理员登录
    Boolean AdminLogin(String name, String pwd);
    //用户登录
    Boolean UserLogin(String name, String pwd);
}
