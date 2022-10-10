package com.Javaone.test;


//单元测试
import com.Javaone.dao.IAdminInfoDao;
import com.Javaone.dao.IGoodsInfoDao;
import com.Javaone.dao.impl.IAdminInfoDaoImpl;
import com.Javaone.dao.impl.IGoodsInfoDaoImpl;
import com.Javaone.pojo.AdminInfo;
import com.Javaone.pojo.GoodsInfo;
import com.Javaone.pojo.UserInfo;
import com.Javaone.util.DBUtil;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class DBUtilTest {
    /*public static void main(String[] args) {

        if (con.getConnection()!=null) {
            System.out.println("成功");
        }else {
            System.out.println("失败");
        }

    }*/
    DBUtil dbUtil = new DBUtil();
    @Test
    public void testQueryResult(){
        String sql = "select * from userinfo";
        ResultSet queryResult = dbUtil.getQueryResult(sql,null);
        List<UserInfo> users = new ArrayList<>();
        try {
            while (queryResult.next()) {
                UserInfo user  = new UserInfo();
                user.setuId(queryResult.getInt("Uid"));
                user.setuName(queryResult.getString("Uname"));
                user.setuPwd(queryResult.getString("Upwd"));
                user.setuPwd(queryResult.getString("Uemail"));
                users.add(user);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        System.out.println(users);
        dbUtil.closeConn();
    }
    @Test
    public void updateTest(){
        String sql = "UPDATE userinfo SET Uname='2333'";
        System.out.println(dbUtil.Update(sql,null) == 0 ? "失败" : "成功");
    }
    @Test
    public void testColse(){
        String sql = "select * from userinfo";
        ResultSet queryResult = dbUtil.getQueryResult(sql,null);
    }
    @Test
    public void testAdminQuery(){
        IAdminInfoDao adminInfo = new IAdminInfoDaoImpl();
        String sql = "select * from adminInfo";
        try {
            List<AdminInfo> adminInfoList = adminInfo.getAdminInfoList();
            for (AdminInfo admins : adminInfoList){
                System.out.println(admins);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void testAddAdminInfo() throws SQLException {
        AdminInfo adminInfo = new AdminInfo();
        adminInfo.setAid(10005);
        adminInfo.setaName("qwer");
        adminInfo.setaPwd("123456");
        adminInfo.setaLevel("超级");
        IAdminInfoDao dao = new IAdminInfoDaoImpl();
        int i = dao.AddAdminInfo(adminInfo);
        System.out.println(i!=0?"成功":"失败");
        dbUtil.closeConn();
    }
    @Test
    public void testUpdateAdminInfo() throws SQLException {
        AdminInfo adminInfo = new AdminInfo();
        adminInfo.setAid(10004);
        adminInfo.setaLevel("普通");
        IAdminInfoDao dao = new IAdminInfoDaoImpl();
        int i = dao.UpdateAdminInfo(adminInfo);
        System.out.println(i!=0?"成功":"失败");
        try {
            List<AdminInfo> adminInfoList = dao.getAdminInfoList();
            for (AdminInfo admins : adminInfoList){
                System.out.println(admins);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void testDeleteAdminInfo() throws SQLException {
        IAdminInfoDao adminInfo = new IAdminInfoDaoImpl();
        int i = adminInfo.DeleteAdminInfo(10004);
        System.out.println(i!=0?"成功":"失败");
    }
    @Test
    public void testGoodsQuery(){
        IGoodsInfoDao iGoodsInfo = new IGoodsInfoDaoImpl();
        Date date = new Date();
        GoodsInfo goodsInfo = new GoodsInfo(80,"时间简史",35.6,"图书",50,date,"12345.jpg",2,"霍金","123456");

    }
    @Test
    public void testCS(){
        AdminInfo adminInfo = new AdminInfo();
        adminInfo.setaName("admin");
        List list = new ArrayList();
        list.add(adminInfo.getaName());
        list.add(adminInfo.getAid());
        list.add(adminInfo.getaPwd());
        list.add(adminInfo.getaLevel());
        System.out.println(list);
    }
    @Test
    public void testConAdminQuery() throws SQLException {
        IAdminInfoDaoImpl dao = new IAdminInfoDaoImpl();
        AdminInfo adminInfo = new AdminInfo();
        adminInfo.setaLevel("超级");
        List<AdminInfo> list = dao.getAdminInfoList(adminInfo);
        for (AdminInfo info : list) {
            System.out.println(info);
        }
    }
    @Test
    public void testGoodsQuerytj() throws SQLException {
        GoodsInfo goodsInfo = new GoodsInfo();
        IGoodsInfoDaoImpl dao = new IGoodsInfoDaoImpl();
        goodsInfo.setgId(807200003);
        List<GoodsInfo> goodsInfoList = dao.getGoodsInfoList();
        for (GoodsInfo i : goodsInfoList){
            System.out.println(i);
        }
    }
    @Test
    public void testAddGoodsInfo(){
        GoodsInfo goodsInfo = new GoodsInfo(807200010,"时间简史",35.9,"图书",20,new Date(),
                "imgs/Time.png",5,"作者：霍金","简介");
        IGoodsInfoDaoImpl dao = new IGoodsInfoDaoImpl();
        System.out.println(dao.AddGoodsInfo(goodsInfo)!=0?"成功":"失败");
    }
    @Test
    public void testUpDateGoodsInfo() throws SQLException {
        GoodsInfo goodsInfo = new GoodsInfo();
        goodsInfo.setgId(807200010);
        goodsInfo.setgPrice(50.0);
        IGoodsInfoDaoImpl dao = new IGoodsInfoDaoImpl();
        dao.UpdateGoodsInfo(goodsInfo);
        List<GoodsInfo> goodsInfoList = dao.getGoodsInfoList();
        for (GoodsInfo goodInfo : goodsInfoList){
            System.out.println(goodInfo);
        }
    }
    @Test
    public void testDeleteGoodsInfo() throws SQLException {
        IGoodsInfoDao dao = new IGoodsInfoDaoImpl();
        System.out.println(dao.DeleteGoodsInfo(807200010)!=0?"成功":"失败");
        dbUtil.closeConn();
    }
    @Test
    public void testDate() throws SQLException {
        ResultSet queryResult = dbUtil.getQueryResult("select * from goodsinfo",null);
        List<GoodsInfo> GoodsInfoList = new ArrayList<>();
        while (queryResult.next()) {
            java.sql.Date gdate = queryResult.getDate("Gdate");
            System.out.println(gdate);
        }
        dbUtil.closeConn();
    }
}
