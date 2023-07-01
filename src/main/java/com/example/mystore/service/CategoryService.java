package com.example.mystore.service;

import com.example.mystore.model.Category;
import com.example.mystore.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    public static final String ID_NOT_EXIST_EXCEPTION = "Category with '%s' id is not found";

    CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category getCategoryById(int id) throws Exception {
        return categoryRepository.findById(id)
                .orElseThrow(() -> exceptionProvider(id));
    }

    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    public void deleteCategory(Category category) {
        categoryRepository.delete(category);
    }

    public List<Category> getCategory() {
        return categoryRepository.findAll();
    }

    protected Exception exceptionProvider(int id) {
        String message = String.format(ID_NOT_EXIST_EXCEPTION, id);

        return new IllegalArgumentException(message);
    }
}
