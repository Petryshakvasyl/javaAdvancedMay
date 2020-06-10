package ua.lviv.lgs.controller;

import org.apache.log4j.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/error")
public class ErrorResponseController extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(ErrorResponseController.class);

    public ErrorResponseController() {
        LOG.info("create error controller");
    }

    @Override
    public void init() {
        LOG.info("init error controller");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        LOG.info("get request to home controller");
        resp.setContentType("text/html");
        String statusCode = req.getParameter("status");
        resp.setStatus(200);
        try {
            int code = Integer.parseInt(statusCode);
//            resp.setStatus(code);
            resp.sendError(code);
        } catch (NumberFormatException e) {
            LOG.error("error read status code parameter ", e);
        }
    }
}
