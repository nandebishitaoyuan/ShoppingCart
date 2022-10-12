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

public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        IsLogin adminLogin = new IsLoginImpl();
        Boolean login = adminLogin.AdminLogin(req.getParameter("name"), req.getParameter("pwd"));
        if (login){
            resp.sendRedirect("/hello/html/admin/cg.html");
        }else {
            resp.sendRedirect("/hello/html/admin/sb.html");
        }
    }
}
