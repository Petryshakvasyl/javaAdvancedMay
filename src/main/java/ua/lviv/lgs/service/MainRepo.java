package ua.lviv.lgs.service;

import ua.lviv.lgs.eintity.User;

import java.sql.Connection;
import java.util.List;

public class MainRepo {

    public static void main(String[] args) {
        Connection connection = ConnectionManager.createConnection();
        UserRepository repository = new UserRepository(connection);
        User user = repository.findById(1);

        System.out.println(user);

        List<User> users = repository.findByLasName("Dovzenko");
        System.out.println(users);

    }
}
