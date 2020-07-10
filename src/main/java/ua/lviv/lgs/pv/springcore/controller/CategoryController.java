package ua.lviv.lgs.pv.springcore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.lviv.lgs.pv.springcore.entity.Category;
import ua.lviv.lgs.pv.springcore.entity.Type;
import ua.lviv.lgs.pv.springcore.service.CategoryService;

@Controller
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/category")
    public String createCategoryPage(Model model, @RequestParam Type type) {
        Category category = new Category();
        category.setType(type);
        model.addAttribute("category", category);
        return "category";
    }

    @PostMapping("/category")
    public String createCategoryPage(@ModelAttribute("category") Category category) {
        return "category";
    }

    @GetMapping("/categories")
    public ModelAndView allCategoriesPage(ModelAndView modelAndView, @RequestParam(required = false, defaultValue = "INCOME") Type type) {
        modelAndView.setViewName("category-list");
        modelAndView.getModelMap().addAttribute("categories", categoryService.findAllByType(type));
        return modelAndView;
    }

    @GetMapping("/categories/{id}")
    public String getCategoryById(Model model, @PathVariable Long id) {
        model.addAttribute("category", categoryService.findById(id));
        return "category-view";
    }
}
