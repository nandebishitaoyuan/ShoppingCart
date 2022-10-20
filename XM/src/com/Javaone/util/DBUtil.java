package com.Javaone.util;

import java.sql.*;
import java.util.List;

public class DBUtil {
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/zyshop";
    private static String name = "root";
    private static String password = "123456";

    //全局
    ResultSet resultSet = null;
    Connection conn = null;
    PreparedStatement statement;

    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public Connection getConnection(){
        try {
            conn = DriverManager.getConnection(url, name, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }
    //条件查询
    public <T> ResultSet getQueryResult(String sql, List<T> list){
        getConnection();
        try {
            statement = conn.prepareStatement(sql);
            if (list != null && list.size() > 0){
                for (int i = 0; i < list.size(); i++) {
                    statement.setObject(i+1,list.get(i));
                }
            }
            return statement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //修改
    public <T> int Update(String sql,List<T> list){
        getConnection();
        try {
            statement = conn.prepareStatement(sql);
            if (list != null && list.size() > 0) {
                for (int i = 0; i < list.size(); i++) {
                    statement.setObject(i+1, list.get(i));
                }
            }
            return statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }finally {
            closeConn();
        }
    }

    //关闭连接
    public void closeConn() {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
