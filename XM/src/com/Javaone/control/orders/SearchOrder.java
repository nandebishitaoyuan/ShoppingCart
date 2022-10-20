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
import java.util.List;

public class SearchOrder extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrderService orderService = new OrderServiceImpl();
        try {
            Integer oid = Integer.parseInt(req.getParameter("orderID"));
            List list = orderService.getOrder(oid);
            if (list == null) {
                PrintWriter out = resp.getWriter();
                out.print("<html><head><meta charset='UTF-8'></head>");
                out.print("<script>alert('未查找到该订单，请重试！');window.location = '/hello/ordersServlet' </script>");
                out.flush();
                out.close();
            }else {
                req.setAttribute("order",list);
                req.getRequestDispatcher("/jsp/order/orderUpdate.jsp").forward(req, resp);
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
