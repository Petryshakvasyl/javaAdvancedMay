package ua.lviv.lgs.pv;

import ua.lviv.lgs.pv.config.ConnectionManager;
import ua.lviv.lgs.pv.entity.Bucket;
import ua.lviv.lgs.pv.entity.User;
import ua.lviv.lgs.pv.repository.BucketRepository;
import ua.lviv.lgs.pv.repository.UserRepository;
import ua.lviv.lgs.pv.repository.impl.BucketRepositoryImpl;
import ua.lviv.lgs.pv.repository.impl.UserRepositoryImpl;
import ua.lviv.lgs.pv.service.UserService;
import ua.lviv.lgs.pv.service.imp.UserServiceImpl;

import java.sql.Connection;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        UserService userService = UserServiceImpl.getInstance();

        User user = new User();
        user.setFirstName("Ivan");
        user.setLastName("Dovzenko");
        user.setEmail("ivan@dovzenko.com");
        user.setPassword("assgjfkjasjfd123");
        user.setRole("USER");
        userService.save(user);

//        Bucket bucket = new Bucket();
//        bucket.setPurchaseDate(LocalDate.now());
//
//        BucketRepository repository = BucketRepositoryImpl.getInstance();
//        repository.save(bucket);

        //
        //        List<User> users = userRepository.findAll();
        //        System.out.println(users);

        //  find b id;

        //        Optional<User> optionalUser = userRepository.findById(2);
        //
        //        optionalUser.ifPresent(System.out::println);

        //delete by id
//        userRepository.deleteById(2);
        ConnectionManager.closeConnection();
    }
}
