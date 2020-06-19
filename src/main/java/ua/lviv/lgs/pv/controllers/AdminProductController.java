package ua.lviv.lgs.pv.controllers;

import org.apache.log4j.Logger;
import org.apache.taglibs.standard.lang.jstl.GreaterThanOperator;
import ua.lviv.lgs.pv.entity.Product;
import ua.lviv.lgs.pv.service.ProductService;
import ua.lviv.lgs.pv.service.imp.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/admin/product")
public class AdminProductController extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(AdminProductController.class);

    private ProductService productService;

    public AdminProductController() {
        this.productService = ProductServiceImpl.getInstantce();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/create-product.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("postRequest to create product");
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String priceString = req.getParameter("price");
        String countString = req.getParameter("count");

        if (isValidCount(countString) && isValidPrice(priceString)) {
            BigDecimal price = new BigDecimal(priceString);
            Long count = Long.valueOf(countString);
            Product product = new Product();
            product.setName(name);
            product.setDescription(description);
            product.setCount(count);
            product.setPrice(price);
            productService.create(product);
            resp.sendRedirect("product");
        } else {
            resp.setStatus(400);
        }
    }

    private boolean isValidCount(String countString) {
        // TODO: 19.06.2020 implement
        return true;
    }

    private boolean isValidPrice(String priceString) {
        // TODO: 19.06.2020 implement
        return true;
    }


}
