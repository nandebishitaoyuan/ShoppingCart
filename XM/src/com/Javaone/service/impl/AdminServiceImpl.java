package com.Javaone.service.impl;

import com.Javaone.dao.IAdminInfoDao;
import com.Javaone.dao.impl.IAdminInfoDaoImpl;
import com.Javaone.pojo.AdminInfo;
import com.Javaone.service.AdminService;

import java.sql.SQLException;
import java.util.List;

public class AdminServiceImpl implements AdminService {
    private IAdminInfoDao adminInfoDao = new IAdminInfoDaoImpl();

    @Override
    public List<AdminInfo> allAdmin() throws SQLException {
        return adminInfoDao.getAdminInfoList();
    }

    @Override
    public Boolean deletAdmin(int id) throws SQLException {
        return adminInfoDao.DeleteAdminInfo(id) > 0;
    }

    @Override
    public Boolean updateAdmin(AdminInfo admin) throws SQLException {
        return adminInfoDao.UpdateAdminInfo(admin) > 0;
    }

    @Override
    public List<AdminInfo> conditionQuery(String name) throws SQLException {
        AdminInfo admin = new AdminInfo();
        admin.setaName(name);
        return ((IAdminInfoDaoImpl)adminInfoDao).getAdminInfoList(admin);
    }


}
