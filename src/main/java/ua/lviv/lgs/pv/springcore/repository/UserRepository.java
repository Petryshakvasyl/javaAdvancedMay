package ua.lviv.lgs.pv.springcore.repository;


import ua.lviv.lgs.pv.springcore.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    List<User> findAll();
}
