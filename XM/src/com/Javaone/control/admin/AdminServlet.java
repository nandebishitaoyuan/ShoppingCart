package com.Javaone.control.admin;

import com.Javaone.pojo.GoodsInfo;
import com.Javaone.service.IsLogin;
import com.Javaone.service.impl.GoodsServiceImpl;
import com.Javaone.service.impl.IsLoginImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

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
        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");
        try {
            Boolean login = adminLogin.AdminLogin(name, pwd);
            HttpSession session = req.getSession();
            if (login){
                session.setAttribute("name",name);
                GoodsServiceImpl goodsService = new GoodsServiceImpl();
                List gClass = goodsService.getgClassInfo();
                List<GoodsInfo> goodsInfos = goodsService.AllGoods();
                req.setAttribute("gClass",gClass);
                req.setAttribute("goodsInfos", goodsInfos);
                req.getRequestDispatcher("/hello/jsp/admin/adminsearch.jsp").forward(req,resp);
            }else {
                PrintWriter out = resp.getWriter();
                out.println("<script>alert('用户名或密码错误');window.location = '/hello/jsp/admin/Login.jsp' </script>");
                out.flush();
                out.close();
            }
        } catch (SQLException | ServletException e) {
            throw new RuntimeException(e);
        }
    }
}
