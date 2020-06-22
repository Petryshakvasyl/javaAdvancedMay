package ua.lviv.lgs.pv.repository.impl;

import org.apache.log4j.Logger;
import ua.lviv.lgs.pv.config.ConnectionManager;
import ua.lviv.lgs.pv.entity.Product;
import ua.lviv.lgs.pv.repository.ProductRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductRepositoryImpl implements ProductRepository {

    private static final Logger log = Logger.getLogger(ProductRepositoryImpl.class);

    private static ProductRepositoryImpl instance;

    private Connection connection;

    private ProductRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    public static ProductRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new ProductRepositoryImpl(ConnectionManager.createConnection());
        }
        return instance;
    }

    @Override
    public void save(Product product) {
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO products(name, description, price, count) values (?,?,?,?)")) {
            statement.setString(1, product.getName());
            statement.setString(2, product.getDescription());
            statement.setBigDecimal(3, product.getPrice());
            statement.setLong(4, product.getCount());
            statement.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public void update(Product product) {
        try (PreparedStatement statement = connection.prepareStatement("UPDATE products p set p.name = ?, p.description=?,p.price=?, p.count=?  where id = ?")) {
            statement.setInt(5, product.getId());
            statement.setString(1, product.getName());
            statement.setString(2, product.getDescription());
            statement.setBigDecimal(3, product.getPrice());
            statement.setLong(4, product.getCount());

            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public List<Product> findAll() {
        List<Product> list = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("SELECT * from products")) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setDescription(resultSet.getString("description"));
                product.setPrice(resultSet.getBigDecimal("price"));
                product.setCount(resultSet.getLong("count"));
                list.add(product);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }

    @Override
    public Optional<Product> findById(Integer integer) {
        Product product = new Product();
        try (PreparedStatement statement = connection.prepareStatement("SELECT * from products where id = ?")) {
            statement.setInt(1, integer);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                product.setId(integer);
                product.setName(resultSet.getString("name"));
                product.setDescription(resultSet.getString("description"));
                product.setPrice(resultSet.getBigDecimal("price"));
                product.setCount(resultSet.getLong("count"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return Optional.of(product);
    }

    @Override
    public void deleteById(Integer integer) {
        try (PreparedStatement statement = connection.prepareStatement("DELETE from products where id = ?")) {
            statement.setInt(1, integer);
            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
