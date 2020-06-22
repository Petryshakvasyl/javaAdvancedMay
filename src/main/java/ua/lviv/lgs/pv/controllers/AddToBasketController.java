package ua.lviv.lgs.pv.controllers;

import ua.lviv.lgs.pv.service.BasketService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/busket/add")
public class AddToBasketController extends HttpServlet {

    private BasketService basketService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Long basketId = (Long) req.getSession().getAttribute("basketId");
        Long productId = Long.valueOf(req.getParameter("productId"));
        Integer productCount = Integer.parseInt(req.getParameter("productCount"));
        basketService.addProductToBasket(productId, productCount, basketId);
        super.doPost(req, resp);
    }
}
