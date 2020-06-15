package ua.lviv.lgs.pv.repository;

import ua.lviv.lgs.pv.entity.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {

    Optional<User> findByEmail(String email);
}
