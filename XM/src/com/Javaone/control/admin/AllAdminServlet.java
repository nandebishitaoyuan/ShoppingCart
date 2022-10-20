package com.Javaone.control.admin;

import com.Javaone.pojo.AdminInfo;
import com.Javaone.service.AdminService;
import com.Javaone.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

public class AllAdminServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        AdminService admin = new AdminServiceImpl();
        HttpSession session = req.getSession();
        if (session.getAttribute("name") != null) {
            try {
                List<AdminInfo> adminInfoList = admin.allAdmin();
                req.setAttribute("adminList", adminInfoList);
                req.getRequestDispatcher("/jsp/admin/admin.jsp").forward(req, resp);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }else {
            PrintWriter out = resp.getWriter();
            out.print("<html><head><meta charset='UTF-8'></head>");
            out.print("<script>alert('请登录！');window.location = '/hello/jsp/admin/Login.jsp' </script>");
            out.flush();
            out.close();
            resp.sendRedirect("/jsp/admin/Login.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
