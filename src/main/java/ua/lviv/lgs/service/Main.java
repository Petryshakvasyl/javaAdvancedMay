package ua.lviv.lgs.service;

import org.apache.log4j.Logger;
import ua.lviv.lgs.eintity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final Logger log = Logger.getLogger(Main.class);
    private static final String url = "jdbc:mysql://localhost:3306/demo?serverTimezone=UTC";
    private static final String user = "db_user";
    private static final String password = "db_pass";

    public static void main(String[] args) {

        log.info("start main");
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM user");
        ) {
            List<User> users = new ArrayList<>();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                users.add(new User(id, firstName, lastName));
            }

            System.out.println(users);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
