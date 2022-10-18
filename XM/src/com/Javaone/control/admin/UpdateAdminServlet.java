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

public class UpdateAdminServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        AdminInfo admin = new AdminInfo(Integer.parseInt(req.getParameter("id")),req.getParameter("name"), req.getParameter("pwd"),req.getParameter("level"));
        AdminService adminService  = new AdminServiceImpl();
        try {
            Boolean i = adminService.updateAdmin(admin);
            PrintWriter out = resp.getWriter();
            out.print("<html><head><meta charset='UTF-8'></head>");
            if (i){
                out.print("<script>alert('修改成功！');window.location = '/hello/jsp/admin/updateAdmin.jsp' </script>");
            }else {
                out.print("<script>alert('修改失败！');window.location = '/hello/jsp/admin/updateAdmin.jsp' </script>");
            }
            out.flush();
            out.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
