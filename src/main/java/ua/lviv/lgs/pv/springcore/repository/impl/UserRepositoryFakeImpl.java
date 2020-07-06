package ua.lviv.lgs.pv.springcore.repository.impl;

import org.springframework.stereotype.Repository;
import ua.lviv.lgs.pv.springcore.entity.User;
import ua.lviv.lgs.pv.springcore.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Repository
public class UserRepositoryFakeImpl implements UserRepository {
    private int randomValue = new Random().nextInt(100);

    @Override
    public List<User> findAll() {
        System.out.println("call basket find all from fake user repository " + randomValue);
        return null;
    }

}
