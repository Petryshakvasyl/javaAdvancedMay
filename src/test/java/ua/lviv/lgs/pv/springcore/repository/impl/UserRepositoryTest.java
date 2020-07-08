package ua.lviv.lgs.pv.springcore.repository.impl;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ua.lviv.lgs.pv.springcore.entity.User;

import java.util.List;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void findByEmail() {
        List<User> all = userRepository.findAll();
        Assertions.assertEquals(0, all.size());
    }

    @Test
    void saveUser() {

    }

    private User createUser() {
        User user = new User();
        user.setEmail("email");
        user.setFirstName("firstName");
        user.setLastName("lastName");
        user.setUsername("username");
        user.setPassword("1234567");
        return user;
    }

}