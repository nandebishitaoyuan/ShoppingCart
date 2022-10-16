package com.Javaone.control;

import com.Javaone.service.Register;
import com.Javaone.service.impl.RegisterImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class AddUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        Register register = new RegisterImpl();
        try {
            Boolean j = register.register(req.getParameter("name"), req.getParameter("pwd"), req.getParameter("email"));
            if (j){
                resp.sendRedirect("/hello/jsp/user/Login.jsp");
            }else {
                resp.sendRedirect("/hello/jsp/user/register.jsp");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
