package ua.lviv.lgs.pv.springcore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.lgs.pv.springcore.dto.CategoryDTO;
import ua.lviv.lgs.pv.springcore.entity.Category;
import ua.lviv.lgs.pv.springcore.entity.Type;
import ua.lviv.lgs.pv.springcore.error.ResourceNotFoundException;
import ua.lviv.lgs.pv.springcore.repository.CategoryRepository;
import ua.lviv.lgs.pv.springcore.service.CategoryService;
import ua.lviv.lgs.pv.springcore.service.mapper.CategoryMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    private final CategoryMapper categoryMapper;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Override
    public List<CategoryDTO> findAllByType(Type type) {
        return categoryRepository.findByType(type).stream().map(categoryMapper::toDTO).collect(Collectors.toList());
    }
}
