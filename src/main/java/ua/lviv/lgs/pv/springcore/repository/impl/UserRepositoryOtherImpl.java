package ua.lviv.lgs.pv.springcore.repository.impl;

import ua.lviv.lgs.pv.springcore.entity.User;
import ua.lviv.lgs.pv.springcore.repository.UserRepository;

import java.util.List;
import java.util.Optional;

public class UserRepositoryOtherImpl implements UserRepository {

    @Override
    public List<User> findAll() {
        System.out.println("I do not know if I am fake or not");
        return null;
    }

}
