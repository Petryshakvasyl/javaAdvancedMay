package ua.lviv.lgs.pv.repository.impl;

import org.apache.log4j.Logger;
import ua.lviv.lgs.pv.config.ConnectionManager;
import ua.lviv.lgs.pv.config.ManagerFactory;
import ua.lviv.lgs.pv.entity.User;
import ua.lviv.lgs.pv.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {

    private static final Logger log = Logger.getLogger(UserRepositoryImpl.class);

    private static UserRepositoryImpl instance;

    private EntityManager em;

    private UserRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    public static UserRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new UserRepositoryImpl(ManagerFactory.createEntityManager());
        }
        return instance;
    }

    @Override
    public void save(User user) {
        em.persist(user);
    }

    @Override
    public void update(User user) {

//        try (PreparedStatement statement = connection.prepareStatement(
//                "update users set first_name =?, last_name=?, email=?, password=?, role=? where id =?")) {
//            statement.setString(1, user.getFirstName());
//            statement.setString(2, user.getLastName());
//            statement.setString(3, user.getEmail());
//            statement.setString(4, user.getPassword());
//            statement.setString(5, user.getRole());
//            statement.setInt(6, user.getId());
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            log.error("error while updating user " + user, e);
//        }
    }

    @Override
    public List<User> findAll() {
        Query query = em.createQuery("select u from User u");
        List<User> resultList = query.getResultList();
        return resultList;
    }

    @Override
    public Optional<User> findById(Integer id) {
        User user = em.find(User.class, id);
        return Optional.ofNullable(user);
    }

    @Override
    public void deleteById(Integer id) {
//        try (PreparedStatement statement = connection.prepareStatement("delete from users where id = ?")) {
//            statement.setInt(1, id);
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            log.error("error while deleting user by id: " + id, e);
//        }
    }

    @Override
    public Optional<User> findByEmail(String email) {

//        Query nativeQuery = em.createNativeQuery("select * from users where email = ?", User.class);
//        nativeQuery.setParameter(1, email);
//        User result = (User) nativeQuery.getSingleResult();
//        return Optional.ofNullable(result);
        TypedQuery<User> query = em.createQuery("select u from User u where u.email = ?1", User.class);
        query.setParameter(1, email);
        User user = query.getSingleResult();
        return Optional.ofNullable(user);
    }
}
