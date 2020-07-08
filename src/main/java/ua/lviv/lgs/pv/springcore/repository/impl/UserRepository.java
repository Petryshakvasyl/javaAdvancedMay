package ua.lviv.lgs.pv.springcore.repository.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.lgs.pv.springcore.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
