package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.entity.ProductViewModel;
import com.netcracker.edu.fapi.service.ProductDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class ProductDataServiceImpl implements ProductDataService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public List<ProductViewModel> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        ProductViewModel[] productModelResponse = restTemplate.getForObject(backendServerUrl + "/api/product/", ProductViewModel[].class);
        return productModelResponse == null ? Collections.emptyList() : Arrays.asList(productModelResponse);
    }

    @Override
    public ProductViewModel getProductById(Long id) {

        RestTemplate restTemplate = new RestTemplate();
        ProductViewModel[] productViewModels = restTemplate.getForObject(backendServerUrl + "/api/product/", ProductViewModel[].class);
        if (productViewModels != null) {
            for (ProductViewModel productViewModel : productViewModels) {
                if (productViewModel.getProductId() == id)
                    return productViewModel;
            }
        }
        return null;
    }

    @Override
    public ProductViewModel saveProduct(ProductViewModel product) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/product", product, ProductViewModel.class).getBody();
    }

    @Override
    public void deleteProduct(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/product/" + id);
    }
}
