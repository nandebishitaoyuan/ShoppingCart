package com.Javaone.service.impl;

import com.Javaone.service.IsLogin;
import org.junit.Test;

import java.sql.SQLException;

public class IsLoginTest {
    @Test
    public void testIsLogin() throws Exception {
        IsLogin isLogin = new IsLoginImpl();
        Boolean adminLogin = isLogin.AdminLogin("郝文韬", "123456");
        System.out.println(adminLogin ? "登录成功" : "登录失败");
    }
    @Test
    public void testUserIsLogin() throws SQLException {
        IsLogin isLogin = new IsLoginImpl();
        Boolean UserLogin = isLogin.UserLogin("郝文韬", "123456789");
        System.out.println(UserLogin ? "登录成功" : "登录失败");
    }
}
