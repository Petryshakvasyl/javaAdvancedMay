package ua.lviv.lgs.pv.springcore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.lgs.pv.springcore.entity.Category;
import ua.lviv.lgs.pv.springcore.entity.Type;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findByType(Type type);
}
