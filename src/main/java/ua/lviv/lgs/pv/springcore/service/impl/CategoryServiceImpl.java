package ua.lviv.lgs.pv.springcore.service.impl;

import org.springframework.stereotype.Service;
import ua.lviv.lgs.pv.springcore.dto.CategoryDTO;
import ua.lviv.lgs.pv.springcore.entity.Category;
import ua.lviv.lgs.pv.springcore.entity.Type;
import ua.lviv.lgs.pv.springcore.service.CategoryService;

import java.util.Arrays;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Override
    public Category findById(Long id) {
        return null;
    }

    @Override
    public List<CategoryDTO> findAllByType(Type type) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setType(type);
        categoryDTO.setName("Gifts");
        return Arrays.asList(categoryDTO);
    }
}
