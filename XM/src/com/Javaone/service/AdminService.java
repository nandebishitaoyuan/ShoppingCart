package com.Javaone.service;

import com.Javaone.pojo.AdminInfo;

import java.sql.SQLException;
import java.util.List;

public interface AdminService {
    /**
     * 查询所有管理员
     * @return 返回所有管理员的List集合
     * @throws SQLException
     */
    List<AdminInfo> allAdmin() throws SQLException;

    /**
     * 删除管理员
     * @param id    管理员ID
     * @return  返回false表示失败，返回true表示成功
     * @throws SQLException
     */
    Boolean deletAdmin(int id) throws SQLException;

    /**
     * 修改管理员信息
     * @param admin 管理员对象
     * @return 返回false表示失败，返回true表示成功
     * @throws SQLException
     */
    Boolean updateAdmin(AdminInfo admin) throws SQLException;

    /**
     * 通过名称查询管理员信息
     * @param name  管理员名称
     * @return  返回一个List集合
     * @throws SQLException
     */
    List<AdminInfo> conditionQuery(String name)throws SQLException;
}
