package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Category;
import com.netcracker.edu.backend.repository.CategoryRepository;
import com.netcracker.edu.backend.repository.UserRepository;
import com.netcracker.edu.backend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository repository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository repository) {

        this.repository = repository;
    }

    @Override
    public Category saveCategory(Category category) {
        return this.repository.save(category);
    }

    @Override
    public Optional<Category> getCategoryById(Long id) {
        return this.repository.findById(id);
    }

    @Override
    public Iterable<Category> getAllCategory() {
        return this.repository.findAll();
    }

    @Override
    public void deleteCategory(Long id) {
        this.repository.deleteById(id);
    }
}
