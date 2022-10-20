package com.Javaone.control.goods;

import com.Javaone.pojo.GoodsInfo;
import com.Javaone.service.GoodsService;
import com.Javaone.service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UpdateGoodsInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        Boolean i = null;
        GoodsService service = new GoodsServiceImpl();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            if ("del".equals(req.getParameter("del"))){
                i = service.delGoods(Integer.parseInt(req.getParameter("gId")));
            }
            if ("add".equals(req.getParameter("add"))){
                GoodsInfo goods = new GoodsInfo(null,req.getParameter("gName"),Double.parseDouble(req.getParameter("gPrice")),req.getParameter("gClass"),Integer.parseInt(req.getParameter("gAmount")),new Date(),req.getParameter("gImgurl"),Integer.parseInt(req.getParameter("hLook")),req.getParameter("gIntro"),req.getParameter("gBrief"));
                System.out.println(goods);
                i = service.addGoods(goods);
            }else {
                GoodsInfo goods = new GoodsInfo(Integer.parseInt(req.getParameter("gId")),req.getParameter("gName"),Double.parseDouble(req.getParameter("gPrice")),req.getParameter("gClass"),Integer.parseInt(req.getParameter("gAmount")),simpleDateFormat.parse(req.getParameter("gDate")),req.getParameter("gImgurl"),Integer.parseInt(req.getParameter("hLook")),req.getParameter("gIntro"),req.getParameter("gBrief"));
                i = service.updateGoodsInfo(goods);
            }
            PrintWriter out = resp.getWriter();
            out.print("<html><head><meta charset='UTF-8'></head>");
            if (i){
                out.print("<script>alert('成功！');window.location = '/hello/allGoodsServlet' </script>");
            }else {
                out.print("<script>alert('失败！');window.location = '/hello/allGoodsServlet' </script>");
            }
            out.flush();
            out.close();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
