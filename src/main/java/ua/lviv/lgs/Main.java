package ua.lviv.lgs;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ua.lviv.lgs.entity.User;
import ua.lviv.lgs.repository.UserRepository;

public class Main {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        UserRepository userRepository = new UserRepository(sessionFactory);

//        User user = createUser(2);
//
//        userRepository.persist(user);
////
//        User user2 = createUser(4);
//        userRepository.save(user2);

//        User user3 = createUser(4);
//        userRepository.merge(user3);
//        user2.setFirstName("Updated");
//        userRepository.merge(user2);
//
////        User user4 = createUser(4);
////        user4.setId(Long.MAX_VALUE);
////        userRepository.update(user4);
//
//        User user5 = createUser(5);
//        userRepository.saveOrUpdate(user5);
//
//        User user = createUser(6);
//        userRepository.update(user);

//        System.out.println(userRepository.findAll());

        User u = createUser(22);
        u.setEmail("unique@emai.com");
        userRepository.persist(u);

        userRepository.findByEmail("unique@emai.com").ifPresent(System.out::println);

    }

    private static User createUser(int count) {
        User user = new User();
        user.setFirstName("Test" + count);
        user.setLastName("TestLast");
        user.setEmail("test@mail.com");
        return user;
    }
}
