package ua.lviv.lgs.pv.springcore.repository;

import org.springframework.beans.factory.annotation.Autowired;
import ua.lviv.lgs.pv.springcore.entity.User;

import javax.persistence.EntityManager;
import java.util.Collections;
import java.util.List;

public class EntityManagerUserRepositoryImpl implements EntityManagerUserRepository {

    @Override
    public List<User> findSpecialUser(String firstName) {
        return Collections.emptyList();
    }
}
