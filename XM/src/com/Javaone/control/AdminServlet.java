package com.Javaone.control;

import com.Javaone.dao.impl.IAdminInfoDaoImpl;
import com.Javaone.pojo.AdminInfo;
import com.Javaone.service.IsLogin;
import com.Javaone.service.impl.IsLoginImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        IsLogin adminLogin = new IsLoginImpl();
        Boolean login = null;
        try {
            login = adminLogin.AdminLogin(req.getParameter("name"), req.getParameter("pwd"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (login){
            resp.sendRedirect("/hello/jsp/admin/ordermanage.jsp");
        }else {
            resp.sendRedirect("/hello/jsp/1.jsp");
        }
    }
}
