package com.Javaone.control.admin;

import com.Javaone.service.AdminService;
import com.Javaone.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class DeletAdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        AdminService adminService = new AdminServiceImpl();
        PrintWriter out = resp.getWriter();
        out.print("<html><head><meta charset='UTF-8'></head>");
            try {
                if ("确定".equals(req.getParameter("yes"))) {
                    Boolean i = adminService.deletAdmin(Integer.parseInt(req.getParameter("id")));
                    if (i){
                        out.print("<script>alert('删除成功！');window.location = '/hello/jsp/admin/deletAdmin.jsp'</script>");
                        out.flush();
                        out.close();
                    }else {
                        out.print("<script>alert('删除失败！');window.location = '/hello/jsp/admin/deletAdmin.jsp' </script>");
                        out.flush();
                        out.close();
                    }
                }
                if("取消".equals(req.getParameter("yes"))) {
                    out.print("<script>alert('取消成功！');window.location = '/hello/jsp/admin/deletAdmin.jsp' </script>");
                    out.flush();
                    out.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
