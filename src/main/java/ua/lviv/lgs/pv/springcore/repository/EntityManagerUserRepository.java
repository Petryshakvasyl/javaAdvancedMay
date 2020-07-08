package ua.lviv.lgs.pv.springcore.repository;

import ua.lviv.lgs.pv.springcore.entity.User;

import java.util.List;

public interface EntityManagerUserRepository {
    List<User> findSpecialUser(String firstName);
}
