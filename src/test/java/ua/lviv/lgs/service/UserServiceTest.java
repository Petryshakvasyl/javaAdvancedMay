package ua.lviv.lgs.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserService();
    }

    @Test
    void getAdminName() {

    }

    @Test
    void notFoundUserWithId() {
        Assertions.assertThrows(UserNotFoundException.class, () -> userService.notFoundUserWithId(1L));
    }

    @ParameterizedTest
    @EnumSource(Status.class)
    void parametrizedTest(Status status) {
        System.out.println(status);
        assertNotNull(status);
    }

    @ParameterizedTest
    @EnumSource(value = Status.class, names = {"NEW", "ACTIVE"})
    void parametrizedTestForFewEnums(Status status) {
        System.out.println(status);
        assertNotNull(status);
    }

    @ParameterizedTest
    @EnumSource(value = Status.class, names = {"NEW", "ACTIVE"})
    @CsvSource({"a1, b1, c1",
            "a2, b2, c2"
    })
    void parametrizedTestForFewEnums(String a, String b, String c) {
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }

    enum Status{
        NEW, ACTIVE, DISABLED, DELETED
    }
}
