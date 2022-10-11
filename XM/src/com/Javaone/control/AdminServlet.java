package com.Javaone.control;

import com.Javaone.dao.impl.IAdminInfoDaoImpl;
import com.Javaone.pojo.AdminInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("GBK");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("第一个Servlet");
        IAdminInfoDaoImpl iAdminInfoDao = new IAdminInfoDaoImpl();
        try {
            List<AdminInfo> adminInfoList = iAdminInfoDao.getAdminInfoList();
            req.setAttribute("admin", adminInfoList);
            req.getRequestDispatcher("/jsp/ServletTest.jsp").forward(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
