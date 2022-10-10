package com.Javaone.dao.impl;

import com.Javaone.dao.IUserInfo;
import com.Javaone.pojo.UserInfo;
import com.Javaone.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IUserInfoImpl implements IUserInfo {
    DBUtil dbUtil = new DBUtil();
    //全查
    @Override
    public List<UserInfo> getUserInfoList() throws SQLException {
        ResultSet queryResult = dbUtil.getQueryResult("select * from userinfo",null);
        List<UserInfo> userInfoList = new ArrayList<>();
        while (queryResult.next()) {
            UserInfo user = new UserInfo();
            user.setuId(queryResult.getInt("Uid"));
            user.setuName(queryResult.getString("Uname"));
            user.setuPwd(queryResult.getString("Upwd"));
            user.setuEmail(queryResult.getString("Uemail"));
            userInfoList.add(user);
        }
        dbUtil.closeConn();
        return userInfoList;
    }
    //条件查
    public List<UserInfo> getUserInfoList(UserInfo userInfo) throws SQLException{
        StringBuffer sql = new StringBuffer(80);
        List list = new ArrayList();
        sql.append("SELECT * FROM userinfo where 1=1 ");
        if (userInfo.getuId()!=null){
            sql.append(" and Uid=?");
            list.add(userInfo.getuId());
        }
        if (userInfo.getuName()!=null){
            sql.append(" and Uname=?");
            list.add(userInfo.getuName());
        }
        if (userInfo.getuPwd()!=null){
            sql.append(" and Upwd=?");
            list.add(userInfo.getuPwd());
        }
        if (userInfo.getuEmail()!=null){
            sql.append(" and Uemail=?");
            list.add(userInfo.getuEmail());
        }
        ResultSet result = dbUtil.getQueryResult(sql.toString(), list);
        List<UserInfo> userInfoList = new ArrayList<>();
        while (result.next()) {
            UserInfo user = new UserInfo();
            user.setuId(result.getInt("Uid"));
            user.setuName(result.getString("Uname"));
            user.setuPwd(result.getString("Upwd"));
            user.setuEmail(result.getString("Uemail"));
            userInfoList.add(user);
        }
        dbUtil.closeConn();
        return userInfoList;
    }
    //添加
    @Override
    public int AddUserInfo(UserInfo user) {
        String sql = "insert into userinfo(Uid,Uname,Upwd,Uemail) values(?,?,?,?)";
        List params = new ArrayList();
        params.add(user.getuId());
        params.add(user.getuName());
        params.add(user.getuPwd());
        params.add(user.getuEmail());
        return dbUtil.Update(sql,params);
    }
    //修改
    @Override
    public int UpdateUserInfo(UserInfo user) {
        List params = new ArrayList<>();
        String sql = "UPDATE userinfo SET ";
        if (user.getuName()!=null) {
            sql+="Uname=?";
            params.add(user.getuName());
        }
        if (user.getuPwd()!=null) {
            if (params.size()>0) {
                sql+=",";
            }
            sql+="Upwd=?";
            params.add(user.getuPwd());
        }
        if (user.getuEmail()!=null) {
            if (params.size()>0) {
                sql+=",";
            }
            sql+="Uemail=?";
            params.add(user.getuEmail());
        }
        if (user.getuId()==null) {
            return 0;
        }else {
            sql+=" where Uid=?";
            params.add(user.getuId());
        }
        return dbUtil.Update(sql, params);
    }
    //删除
    @Override
    public int DeleteUserInfo(int id) {
        String sql = "delete from userinfo where Uid=?";
        List params = new ArrayList();
        params.add(id);
        return dbUtil.Update(sql,params);
    }
}
