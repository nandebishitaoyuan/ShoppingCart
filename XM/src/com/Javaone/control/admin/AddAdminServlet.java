package com.Javaone.control.admin;

import com.Javaone.service.AdminService;
import com.Javaone.service.Register;
import com.Javaone.service.impl.AdminServiceImpl;
import com.Javaone.service.impl.RegisterImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class AddAdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        Register register = new RegisterImpl();
        try {
            Boolean i = register.adminRegister(req.getParameter("name"), req.getParameter("pwd"), req.getParameter("level"));
            PrintWriter out = resp.getWriter();
            out.print("<html><head><meta charset='UTF-8'></head>");
            if (i){
                out.print("<script>alert('添加成功！');window.location = '/hello/allAdminServlet' </script>");
                out.flush();
                out.close();
                resp.sendRedirect("/jsp/admin/Login.jsp");
            }else {
                out.print("<script>alert('添加失败！');window.location = '/hello/jsp/admin/admin.jsp' </script>");
                out.flush();
                out.close();
                resp.sendRedirect("/jsp/admin/addAdmin.jsp");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
