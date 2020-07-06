package ua.lviv.lgs.pv.springcore.service;


import ua.lviv.lgs.pv.springcore.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAll();

}
