package ua.lviv.lgs.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static final String url = "jdbc:mysql://localhost:3306/demo?serverTimezone=UTC";
    private static final String user = "db_user";
    private static final String password = "db_pass";

    private ConnectionManager() {

    }

    private static Connection instance;

    public static Connection createConnection(){
        if (instance == null) {
            try {
                instance = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

}
