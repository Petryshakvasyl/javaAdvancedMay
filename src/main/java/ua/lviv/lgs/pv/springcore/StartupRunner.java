//package ua.lviv.lgs.pv.springcore;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.stereotype.Component;
//import ua.lviv.lgs.pv.springcore.dto.UserDTO;
//import ua.lviv.lgs.pv.springcore.service.UserService;
//
//@Component
//public class StartupRunner implements CommandLineRunner {
//
//    @Autowired
//    private UserService userService;
//
//    @Override
//    public void run(String... args) throws Exception {
//        UserDTO userDTO = new UserDTO();
//        userDTO.setEmail("user@mail.com");
//        userDTO.setFirstName("user");
//        userDTO.setLastName("User");
//        userDTO.setPassword("1111");
////        userDTO.setUsername("username");
//        userService.createUser(userDTO);
//    }
//}
