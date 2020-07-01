package ua.lviv.lgs.repository;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ua.lviv.lgs.entity.User;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class UserRepository {

    private final SessionFactory sessionFactory;

    public void persist(User user) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(user);

//            session.evict(user);
            session.persist(user);
            transaction.commit();
        }
    }

    public User save(User user) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Long id = (Long) session.save(user);
            session.evict(user);
            Long id2 = (Long) session.save(user);
            transaction.commit();
            return user;
        }
    }

    public User merge(User user) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            User mergedUser = (User) session.merge(user);
            transaction.commit();
            return mergedUser;
        }
    }

    /**
     * PersistenceException for transient instance */
    public User update(User user) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
            return user;
        }
    }

    public User saveOrUpdate(User user) {
        try (Session session = sessionFactory.openSession()) {

            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(user);
            transaction.commit();
            return user;
        }
    }

    public List<User> findAll() {
        try (Session session = sessionFactory.openSession()) {
//            List<User> allUsers = session.createQuery("select u from User u", User.class).list();
//            return allUsers;
            return session.createNamedQuery("queryName", User.class).list();

        }
    }

    public Optional<User> findByEmail(String email) {
        User singleResult = null;
        try (Session session = sessionFactory.openSession()) {
            Query<User> query = session.createQuery("select u from User u where u.email = ?1", User.class);
            query.setParameter(1, email);
            singleResult = query.getSingleResult();
        }
        return Optional.ofNullable(singleResult);
    }

}
