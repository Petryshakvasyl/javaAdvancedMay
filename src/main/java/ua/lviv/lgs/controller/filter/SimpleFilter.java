package ua.lviv.lgs.controller.filter;

import org.apache.log4j.Logger;
import ua.lviv.lgs.controller.ErrorResponseController;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class SimpleFilter implements Filter {

    private static final Logger LOG = Logger.getLogger(SimpleFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOG.info("init filter");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        LOG.info("do filter");

        // Get the IP address of client machine.
        String ipAddress = request.getLocalAddr();

        // Pass request back down the filter chain
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
