package ua.lviv.lgs.service;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class MessageServiceTest {

    private MessageService messageService;

    @Mock
    private UserService userService;

    @BeforeAll
    static void beforeAll(){
        System.out.println("Before all");
    }

    @BeforeEach
    void setUp() {
        messageService = new MessageService(userService);
        System.out.println("    before each");
    }

    @AfterEach
    void tearDown() {
        System.out.println("    after each");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("After all");
    }

    @Test
    void generateDefaultMessage_ReturnNotNullValue() {
        String actualMessage = messageService.generateDefaultMessage();
        Assertions.assertNotNull(actualMessage);
    }

    @Test
    void generateDefaultMessage_ReturnHello() {
        String actualMessage = messageService.generateDefaultMessage();
        Assertions.assertEquals("Hello", actualMessage);
    }

    @Test
    void generateMessageForAdmin_ReturnHelloAdminName(){
        Mockito.when(userService.getAdminName()).thenReturn("Admin");
        String adminMessage = messageService.generateMessageForAdmin();
        Assertions.assertEquals("Hello Admin", adminMessage);
    }

    @Test
    void generateMessageForUser_ReturnHelloUserName(){
        Mockito.when(userService.getUserName()).thenReturn("Niklaz");
        String userMessage = messageService.generateMessageForUser();
        Assertions.assertEquals("Hello user ", userMessage);
    }

}
