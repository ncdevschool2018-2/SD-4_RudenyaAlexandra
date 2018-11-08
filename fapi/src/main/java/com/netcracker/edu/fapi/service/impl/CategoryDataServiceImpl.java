package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.entity.CategoryViewModel;
import com.netcracker.edu.fapi.service.CategoryDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class CategoryDataServiceImpl implements CategoryDataService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public List<CategoryViewModel> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        CategoryViewModel[] categoryModelResponse = restTemplate.getForObject(backendServerUrl + "/api/category", CategoryViewModel[].class);
        return categoryModelResponse == null ? Collections.emptyList() : Arrays.asList(categoryModelResponse);
    }

    @Override
    public CategoryViewModel getCategoryById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        CategoryViewModel[] categoryViewModels = restTemplate.getForObject(backendServerUrl + "/api/category/", CategoryViewModel[].class);

        if (categoryViewModels != null) {
            for (CategoryViewModel categoryViewModel : categoryViewModels) {
                if (categoryViewModel.getCategory_id() == id)
                    return categoryViewModel;
            }
        }
        return null;
    }

    @Override
    public CategoryViewModel saveCategory(CategoryViewModel category) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/category", category, CategoryViewModel.class).getBody();
    }

    @Override
    public void deleteCategory(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/category/" + id);
    }
}
