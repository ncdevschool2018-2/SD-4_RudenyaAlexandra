package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Category;

import java.util.Optional;

public interface CategoryService {
    Category saveCategory(Category user);
    Optional<Category> getCategoryById(Long id);
    Iterable<Category> getAllCategory();
    void deleteCategory(Long id);
}
