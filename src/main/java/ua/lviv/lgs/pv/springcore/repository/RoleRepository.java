package ua.lviv.lgs.pv.springcore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.lgs.pv.springcore.entity.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
