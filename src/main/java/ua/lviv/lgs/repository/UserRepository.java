package ua.lviv.lgs.repository;

import ua.lviv.lgs.eintity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private final static String CREATE = "insert into user(`first_name`, `last_name`) values (?,?)";

    private Connection connection;

    public UserRepository(Connection connection) {
        this.connection = connection;
    }

    public User findById(Integer id) {
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

    public List<User> findByLasName(String lastName) {
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

    public User save(User user) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.executeUpdate();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            rs.next();
            user.setId(rs.getInt(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public List<User> findAll() {
        PreparedStatement preparedStatement;
        List<User> userRecords = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement("select * from user");
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                userRecords.add(mapToUser(result));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userRecords;
    }

    private User mapToUser(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String firstName = resultSet.getString("first_name");
        String lastName = resultSet.getString("last_name");
        return new User(id, firstName, lastName);
    }

    public void delete(Integer id) {
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement("delete from user where id=?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
