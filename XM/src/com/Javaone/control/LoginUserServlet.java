package com.Javaone.control;

import com.Javaone.service.IsLogin;
import com.Javaone.service.impl.IsLoginImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class LoginUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        IsLogin userLogin = new IsLoginImpl();
        Boolean login = null;
        try {
            login = userLogin.UserLogin(req.getParameter("name"), req.getParameter("pwd"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (login){
            resp.sendRedirect("/hello/jsp/user/cart.jsp");
        }else {
            resp.sendRedirect("/hello/jsp/1.jsp");
        }
    }
}
