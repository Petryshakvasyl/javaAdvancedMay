package ua.lviv.lgs.pv.springcore.repository.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import ua.lviv.lgs.pv.springcore.entity.User;
import ua.lviv.lgs.pv.springcore.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Repository
@Primary
public class UserRepositoryImpl implements UserRepository {

    private UserRepositoryImpl() {

    }

    @Override
    public List<User> findAll() {
        System.out.println("I am not fake impl");
        return null;
    }

}
