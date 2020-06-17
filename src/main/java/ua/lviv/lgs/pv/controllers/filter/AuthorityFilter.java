package ua.lviv.lgs.pv.controllers.filter;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class AuthorityFilter implements Filter {

    private final Logger log = Logger.getLogger(AuthorityFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("init filter " + filterConfig.getFilterName());
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("filter log in");
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession();
        boolean isLoggedIn = session != null && session.getAttribute("userEmail") != null;
        boolean isLoginPage = httpRequest.getRequestURI().endsWith("login");
        boolean isRegistrationPage = httpRequest.getRequestURI().endsWith("registration");
        if (isLoggedIn) {
            if (isLoginPage || isRegistrationPage) {
                httpRequest.getRequestDispatcher("home.jsp").forward(request, response);
            } else {
                chain.doFilter(request, response);
            }
        } else if (isLoginPage || isRegistrationPage) {
            chain.doFilter(request, response);
        } else {
            ((HttpServletResponse) response).sendRedirect("/login");
//            httpRequest.getRequestDispatcher("/login").forward(request, response);
        }
    }

    @Override
    public void destroy() {
        log.info("destroy");
    }
}
