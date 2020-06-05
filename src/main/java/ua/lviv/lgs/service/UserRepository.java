package ua.lviv.lgs.service;

import ua.lviv.lgs.eintity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private Connection connection;

    public UserRepository(Connection connection) {
        this.connection = connection;
    }

    User findById(Integer id) {
        User result = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM user where id = ?")) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            result = mapToUser(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    List<User> findByLasName(String lastName) {
        List<User> result = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM user where last_name = ?")) {
            preparedStatement.setString(1, lastName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                result.add(mapToUser(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    private User mapToUser(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String firstName = resultSet.getString("first_name");
        String lastName = resultSet.getString("last_name");
        return new User(id, firstName, lastName);
    }
}
