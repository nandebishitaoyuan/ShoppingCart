package com.Javaone.service;

import java.sql.SQLException;

public interface Register {
    //用户注册
    Boolean userRegister(String name, String pwd, String email) throws SQLException;
}
