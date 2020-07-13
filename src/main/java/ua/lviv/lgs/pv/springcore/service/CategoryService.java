package ua.lviv.lgs.pv.springcore.service;

import ua.lviv.lgs.pv.springcore.dto.CategoryDTO;
import ua.lviv.lgs.pv.springcore.entity.Category;
import ua.lviv.lgs.pv.springcore.entity.Type;

import java.util.List;

public interface CategoryService {

    Category findById(Long id);

    List<CategoryDTO> findAllByType(Type type);

}
