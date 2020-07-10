package ua.lviv.lgs.pv.springcore.service.impl;

import org.springframework.stereotype.Service;
import ua.lviv.lgs.pv.springcore.entity.Category;
import ua.lviv.lgs.pv.springcore.entity.Type;
import ua.lviv.lgs.pv.springcore.service.CategoryService;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {



    @Override
    public Category findById(Long id) {
        return null;
    }

    @Override
    public List<Category> findAllByType(Type type) {
        return null;
    }
}
