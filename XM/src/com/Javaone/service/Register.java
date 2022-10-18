package com.Javaone.service;

import java.sql.SQLException;

public interface Register {
    /**
     * 用户注册
     * @param name 用户名
     * @param pwd   密码
     * @param email 邮箱
     * @return
     * @throws SQLException
     */
    Boolean userRegister(String name, String pwd, String email) throws SQLException;

    /**
     * 添加管理员
     * @param name  用户名
     * @param pwd   密码
     * @return
     * @throws SQLException
     */
    Boolean adminRegister(String name, String pwd, String level) throws SQLException;
}
