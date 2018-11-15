package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.entity.CategoryViewModel;
import com.netcracker.edu.fapi.service.CategoryDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryDataController {

    @Autowired
    private CategoryDataService categoryDataService;

    @RequestMapping
    public ResponseEntity<List<CategoryViewModel>> getAllCategory() {

        return ResponseEntity.ok(categoryDataService.getAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<CategoryViewModel> getCategoryById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(categoryDataService.getCategoryById(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<CategoryViewModel> saveCategory(@RequestBody CategoryViewModel category /*todo server validation*/) {
        if (category != null) {
            return ResponseEntity.ok(categoryDataService.saveCategory(category));
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteCategory(@PathVariable String id) {
        categoryDataService.deleteCategory(Long.valueOf(id));
    }

}
