package ua.lviv.lgs.pv.springcore.repository;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ua.lviv.lgs.pv.springcore.entity.User;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void findByAll() {
        List<User> all = userRepository.findAll();
        Assertions.assertEquals(0, all.size());
    }

    @BeforeEach
    void setup() {
        userRepository.deleteAll();
    }

    @Test
    void findByEmail() {
        String email = "user@mail1.com";
        User user = createUser(email);
        userRepository.save(user);

        Optional<User> result = userRepository.findByEmail(email);
        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals(email, result.get().getEmail());
    }

    @Test
    void findSpecialUserTest() {
        List<User> result = userRepository.findSpecialUser("any");
        Assertions.assertNotNull(result);
        Assertions.assertTrue(result.isEmpty());
    }

    @Test
    void saveUser() {
        User user = createUser("user@mail.com");
        userRepository.save(user);
        Assertions.assertNotNull(user.getId());
    }

    @Test
    public void findByFirstNameAndLastNameTest() {
        User user = createUser("user@mail.com");
        userRepository.save(user);
        List<User> result = userRepository.findByFirstNameAndLastName("firstName", "lastName");
        Assertions.assertEquals(1, result.size());
    }

    private User createUser(String email) {
        User user = new User();
        user.setEmail(email);
        user.setFirstName("firstName");
        user.setLastName("lastName");
        user.setUsername("username");
        user.setPassword("1234567");
        return user;
    }

}