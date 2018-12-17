package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.entity.ProductViewModel;
import com.netcracker.edu.fapi.service.ProductDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.awt.print.Pageable;
import java.util.Arrays;
import java.util.Collection;
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

    //спросить про массив, почему не list?
    @Override
    public List<ProductViewModel> getProductByCategoryId(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        ProductViewModel productViewModel[] = restTemplate.getForObject(backendServerUrl + "/api/product/category/"
        + id, ProductViewModel[].class);
        return productViewModel == null ? Collections.emptyList(): Arrays.asList(productViewModel);
    }

    @Override
    public RestPageImpl<ProductViewModel> getProductPage(HttpServletRequest request) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(backendServerUrl + "/api/product/page?" + request.getQueryString(),
                HttpMethod.GET, null,
                new ParameterizedTypeReference<RestPageImpl<ProductViewModel>>(){})
                .getBody();
    }
}
