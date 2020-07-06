package ua.lviv.lgs.pv.springcore.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.lgs.pv.springcore.entity.User;
import ua.lviv.lgs.pv.springcore.repository.BasketRepository;
import ua.lviv.lgs.pv.springcore.repository.UserRepository;
import ua.lviv.lgs.pv.springcore.service.UserService;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    //field injection (not recommended)
    //@Autowired
    private UserRepository userRepository;
    //field injection (not recommended)
    //@Autowired
    private BasketRepository basketRepository;

    //Constructor injection (recommended)
    @Autowired
    public UserServiceImpl(UserRepository userRepository, BasketRepository basketRepository) {
        this.userRepository = userRepository;
        this.basketRepository = basketRepository;
    }

    @Override
    public List<User> findAll() {
        basketRepository.findAll();
        return userRepository.findAll();
    }
        //setter injection
//    @Autowired
//    public void setUserRepository(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Autowired
//    public void setBasketRepository(BasketRepository basketRepository) {
//        this.basketRepository = basketRepository;
//    }
}
