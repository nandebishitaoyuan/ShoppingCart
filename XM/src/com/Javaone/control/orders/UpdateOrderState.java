package com.Javaone.control.orders;

import com.Javaone.service.OrderService;
import com.Javaone.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class UpdateOrderState extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        OrderService orderService = new OrderServiceImpl();
        try {
            Boolean order = orderService.updateOrder(Integer.parseInt(req.getParameter("oid")), req.getParameter("state"));
            System.out.println(req.getParameter("state"));
            PrintWriter out = resp.getWriter();
            out.print("<html><head><meta charset='UTF-8'></head>");
            if (order){
                out.print("<script>alert('修改成功！');window.location = '/hello/ordersServlet' </script>");
            }else {
                out.print("<script>alert('修改失败！');window.location = '/hello/ordersServlet' </script>");
            }
            out.flush();
            out.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
