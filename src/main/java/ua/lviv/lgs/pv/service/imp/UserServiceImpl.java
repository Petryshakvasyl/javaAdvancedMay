package ua.lviv.lgs.pv.service.imp;

import org.apache.log4j.Logger;
import ua.lviv.lgs.pv.entity.Bucket;
import ua.lviv.lgs.pv.entity.User;
import ua.lviv.lgs.pv.repository.BucketRepository;
import ua.lviv.lgs.pv.repository.UserRepository;
import ua.lviv.lgs.pv.repository.impl.BucketRepositoryImpl;
import ua.lviv.lgs.pv.repository.impl.UserRepositoryImpl;
import ua.lviv.lgs.pv.service.UserService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    private static Logger log = Logger.getLogger(UserServiceImpl.class);

    private UserRepository userRepository;

    private BucketRepository bucketRepository;

    private static UserServiceImpl instance;

    private UserServiceImpl(UserRepository userRepository, BucketRepository bucketRepository) {
        this.userRepository = userRepository;
        this.bucketRepository = bucketRepository;
    }

    public static UserServiceImpl getInstance() {
        if (instance == null) {
            instance = new UserServiceImpl(UserRepositoryImpl.getInstance(), BucketRepositoryImpl.getInstance());
        }
        return instance;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        log.debug("find user by email " + email);
        return userRepository.findByEmail(email);
    }

    @Override
    public void save(User user) {
        Bucket bucket = new Bucket();
        bucket.setPurchaseDate(LocalDate.now());
        bucketRepository.save(bucket);
        user.setBucketId(bucket.getId());
        log.debug("save new user " + user);
        user.setRole("USER");
        userRepository.save(user);
    }

    @Override
    public void update(User user) {
        log.debug("update user " + user);
        userRepository.update(user);
    }

    @Override
    public List<User> findAll() {
        log.debug("find all users");
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Integer id) {
        log.debug("find user by id " + id);
        return userRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        log.debug("delete user by id " + id);
        userRepository.deleteById(id);
    }
}
