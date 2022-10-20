package com.Javaone.control.goods;

import com.Javaone.pojo.GoodsInfo;
import com.Javaone.service.GoodsService;
import com.Javaone.service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AllGoodsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GoodsService goodsService = new GoodsServiceImpl();
        try {
            List<GoodsInfo> goodsInfoList = goodsService.allGoods();
            req.setAttribute("goods", goodsInfoList);
            req.getRequestDispatcher("/jsp/admin/CManagement.jsp").forward(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
