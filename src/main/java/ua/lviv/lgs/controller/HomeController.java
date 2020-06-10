package ua.lviv.lgs.controller;

import org.apache.log4j.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/home")
public class HomeController extends HttpServlet {

    private String message;

    private static final Logger LOG = Logger.getLogger(HomeController.class);

    public HomeController() {
        LOG.info("create home controller");
    }

    @Override
    public void init() {
        LOG.info("init home controller");
        message = ", welcome";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        LOG.info("get request to home controller");
        resp.setContentType("text/html");
        resp.getWriter().write("<h2>Hello from Servlet" + message + "</h2>");
    }

    @Override
    public void destroy() {
        LOG.info("destroy method called");
    }
}
