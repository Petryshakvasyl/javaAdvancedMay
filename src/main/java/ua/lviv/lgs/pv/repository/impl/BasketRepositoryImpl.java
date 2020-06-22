package ua.lviv.lgs.pv.repository.impl;

import org.apache.log4j.Logger;
import ua.lviv.lgs.pv.config.ConnectionManager;
import ua.lviv.lgs.pv.entity.Bucket;
import ua.lviv.lgs.pv.entity.Product;
import ua.lviv.lgs.pv.repository.BasketRepository;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class BasketRepositoryImpl implements BasketRepository {

    private static final Logger LOG = Logger.getLogger(BasketRepositoryImpl.class);

    private Connection connection;

    private BasketRepositoryImpl() {
        this.connection = ConnectionManager.createConnection();
    }

    private static BasketRepositoryImpl instance;

    public static BasketRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new BasketRepositoryImpl();
        }
        return instance;
    }

    @Override
    public void save(Bucket bucket) {
        try (PreparedStatement statement = connection.prepareStatement(
                "insert into bucket (purchase_date) value (?)",  Statement.RETURN_GENERATED_KEYS)) {
            statement.setDate(1, Date.valueOf(bucket.getPurchaseDate()));
            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                bucket.setId(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {

        }
    }

    @Override
    public void update(Bucket bucket) {

    }

    @Override
    public List<Bucket> findAll() {
        return null;
    }

    @Override
    public Optional<Bucket> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void addProductToBasket(Long productId, Integer productCount, Long basketId) {

    }

    @Override
    public List<Product> findByBasketId(Long basketId) {
        return null;
    }

    @Override
    public int getProductsCountInBasket(Long basketId) {
        return 0;
    }
}
