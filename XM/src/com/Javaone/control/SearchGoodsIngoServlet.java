package com.Javaone.control;

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

public class SearchGoodsIngoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GoodsService goodsService = new GoodsServiceImpl();
        try {
            List<GoodsInfo> tsearch = goodsService.getGoodsLike(req.getParameter("tsearch"));
            System.out.println(tsearch);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
