package ua.lviv.lgs.service;

import org.apache.log4j.Logger;
import ua.lviv.lgs.eintity.User;
import ua.lviv.lgs.repository.UserRepository;

import java.sql.Connection;
import java.util.List;

public class MainRepo {

    private static final Logger LOG = Logger.getLogger(MainRepo.class);

    public static void main(String[] args) {
        LOG.info("main is started ...");

        Connection connection = ConnectionManager.createConnection();
        UserRepository repository = new UserRepository(connection);
        User user = repository.findById(1);

        LOG.debug("find user by id " + user);

        List<User> users = repository.findByLasName("Dovzenko");
        LOG.debug("find all users " + users);

        LOG.info("main is finished ...");
    }
}
