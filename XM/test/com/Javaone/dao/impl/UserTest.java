package com.Javaone.dao.impl;

import com.Javaone.dao.impl.IUserInfoImpl;
import com.Javaone.pojo.UserInfo;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class UserTest {
    @Test
    public void testQuery() throws SQLException {
        IUserInfoImpl userInfo = new IUserInfoImpl();
        List<UserInfo> list = userInfo.getUserInfoList();
        for (UserInfo users : list) {
            System.out.println(users);
        }
    }
    @Test
    public void testConQuery() throws SQLException {
        IUserInfoImpl userInfo = new IUserInfoImpl();
        UserInfo user = new UserInfo();
        user.setuId(10001);
        List<UserInfo> list = userInfo.getUserInfoList(user);
        for (UserInfo users : list) {
            System.out.println(users);
        }
    }
    @Test
    public void testAdd() throws SQLException {
        IUserInfoImpl userInfo = new IUserInfoImpl();
        UserInfo user = new UserInfo();
        user.setuId(10003);
        user.setuName("郝文韬");
        user.setuPwd("123456789");
        user.setuEmail("2542209451@qq.com");
        System.out.println(userInfo.AddUserInfo(user)!=0?"成功":"失败");
        testQuery();
    }
    @Test
    public void testUpdate() throws SQLException {
        IUserInfoImpl userInfo = new IUserInfoImpl();
        UserInfo user = new UserInfo();
        user.setuId(10003);
        user.setuName("郝文韬");
        user.setuPwd("qwertyuiop");
        user.setuEmail("123452@qq.com");
        userInfo.UpdateUserInfo(user);
        testQuery();
    }
    @Test
    public void testDelete() throws SQLException {
        IUserInfoImpl userInfo = new IUserInfoImpl();
        userInfo.DeleteUserInfo(10003);
        testQuery();
    }
}
