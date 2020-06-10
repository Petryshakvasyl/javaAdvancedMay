package ua.lviv.lgs.controller;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/form")
public class FormController extends HttpServlet {


    private static final Logger LOG = Logger.getLogger(FormController.class);

    public FormController() {
        LOG.info("create form controller");
    }

    @Override
    public void init() {
        LOG.info("init form controller");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        LOG.info("get request to form controller");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");

        resp.setContentType("text/html");
        logRequestInfo(req);
        resp.getWriter().write("<h2>Hello " + firstName + " " + lastName + " !</h2>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("post request to form controller");
        logRequestInfo(req);
        doGet(req, resp);
    }

    private void logRequestInfo(HttpServletRequest req) {
        LOG.info("session : " + req.getSession().getId());
        LOG.info("locale :" + req.getLocale());
        LOG.info("auth type : " + req.getAuthType());
        LOG.info("char encoding : " + req.getCharacterEncoding());
        LOG.info("content type : " + req.getContentType());
        LOG.info("content path : " + req.getContextPath());
        LOG.info("method: " + req.getMethod());
        LOG.info("query string : " + req.getQueryString());
    }

    @Override
    public void destroy() {
        LOG.info("destroy method called");
    }
}
