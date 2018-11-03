package com.netcracker.edu.fapi.service;


import com.netcracker.edu.fapi.entity.CategoryViewModel;
import java.util.List;

public interface CategoryDataService {
    List<CategoryViewModel> getAll();
    CategoryViewModel getCategoryById(Long id);
    CategoryViewModel saveCategory(CategoryViewModel category);
    void deleteCategory(Long id);
}
