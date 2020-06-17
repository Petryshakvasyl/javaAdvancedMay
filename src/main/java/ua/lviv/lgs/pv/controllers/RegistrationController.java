package ua.lviv.lgs.pv.controllers;

import org.apache.log4j.Logger;
import ua.lviv.lgs.pv.entity.User;
import ua.lviv.lgs.pv.service.UserService;
import ua.lviv.lgs.pv.service.imp.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/registration")
public class RegistrationController extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(RegistrationController.class);

    private UserService userService;

    public RegistrationController() {
        this.userService = UserServiceImpl.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);

        if (isValidUser(user)) {
            Optional<User> userByEmail = userService.findByEmail(email);
            if (userByEmail.isPresent()) {
                resp.setStatus(422);
            }else {
                userService.save(user);
                resp.sendRedirect("/login");
            }
        }else {
            LOG.warn("invalid input data");
            resp.setStatus(400);
        }
    }

    private boolean isValidUser(User user) {
        return user.getPassword() != null
                && user.getEmail() != null
                && user.getFirstName() != null
                && user.getLastName() != null;
    }
}
