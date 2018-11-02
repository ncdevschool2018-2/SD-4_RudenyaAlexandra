package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.Category;
import com.netcracker.edu.backend.repository.CategoryRepository;
import com.netcracker.edu.backend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)//сопоставление запросов
    public ResponseEntity<Category> getCategoryById(@PathVariable(name = "id") Long id){
        Optional<Category> category = categoryService.getCategoryById(id);
        if(category.isPresent()){
            return ResponseEntity.ok(category.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }//ответ

    @RequestMapping(value = "", method = RequestMethod.GET)//сопоставление запросов
    public Iterable<Category> getAllCategory(){
        return categoryService.getAllCategory();
    }//ответ

    @RequestMapping(method = RequestMethod.POST)//сопоставление запросов
    public Category saveCategory(@RequestBody Category category){
        return this.categoryService.saveCategory(category);
    }//ответ

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)//сопоставление запросов
    public ResponseEntity deleteCategorytById(@PathVariable(name = "id") Long id){
        this.categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }//ответ
}
