package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Product;

import java.util.Optional;

public interface ProductService {
    Product saveProduct(Product product);
    Optional<Product> getProductById(Long id);
    Iterable<Product> getAllProduct();
    void deleteProduct(Long id);
}
