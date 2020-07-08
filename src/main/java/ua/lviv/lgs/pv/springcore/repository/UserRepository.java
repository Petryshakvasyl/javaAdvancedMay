package ua.lviv.lgs.pv.springcore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.lgs.pv.springcore.entity.User;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>, EntityManagerUserRepository {

    Optional<User> findByEmail(String email);

    List<User> findByFirstNameAndLastName(String firsName, String lastName);

}
