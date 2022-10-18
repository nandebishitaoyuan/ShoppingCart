package com.Javaone.control.admin;

import com.Javaone.pojo.AdminInfo;
import com.Javaone.service.AdminService;
import com.Javaone.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

public class Search extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        AdminService adminService = new AdminServiceImpl();
        try {
            List<AdminInfo> adminList = adminService.conditionQuery(req.getParameter("name"));
            if (adminList != null && adminList.size() > 0) {
                req.setAttribute("adminList", adminList);
                req.getRequestDispatcher("/jsp/admin/updateAdmin.jsp").forward(req, resp);
            }else {
                PrintWriter out = resp.getWriter();
                out.print("<html><head><meta charset='UTF-8'></head>");
                out.print("<script>alert('未查找到管理员，请重试！');window.location = '/hello/jsp/admin/updateAdmin.jsp' </script>");
                out.flush();
                out.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
