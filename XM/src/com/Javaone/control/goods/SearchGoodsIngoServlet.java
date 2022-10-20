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

public class SearchGoodsIngoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        GoodsService goodsService = new GoodsServiceImpl();
        try {
            if (req.getParameter("gName") != null){
                List<GoodsInfo> goodsInfoList = goodsService.getGoodsLike(req.getParameter("gName"));
                req.setAttribute("gList", goodsInfoList);
                System.out.println(goodsInfoList);
                System.out.println(req.getParameter("gName"));
                req.getRequestDispatcher("/jsp/goods/goodsInfo.jsp").forward(req, resp);
            }
            if (req.getParameter("tsearch") != null){
                List<GoodsInfo> tsearchs = goodsService.getGoodsLike(req.getParameter("tsearch"));
                req.setAttribute("tsearchs", tsearchs);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
