package com.example.mystore.restController;

import com.example.mystore.model.Category;
import com.example.mystore.service.CategoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(path = "/category", method = RequestMethod.GET)
    public List<Category> findAll() {
        return categoryService.getCategory();
    }
}
