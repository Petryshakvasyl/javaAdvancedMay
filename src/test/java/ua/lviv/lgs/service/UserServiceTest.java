package ua.lviv.lgs.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
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
        assertThrows(UserNotFoundException.class, () -> userService.notFoundUserWithId(1L));
    }

    @ParameterizedTest
    @EnumSource(Status.class)
    void parametrizedTest(Status status) {
        assertNotNull(status);
    }

    enum Status{
        NEW, ACTIVE, DISABLED, DELETED
    }
}
