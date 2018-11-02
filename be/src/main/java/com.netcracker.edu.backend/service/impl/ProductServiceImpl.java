package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Comment;
import com.netcracker.edu.backend.entity.Product;
import com.netcracker.edu.backend.repository.CommentRepository;
import com.netcracker.edu.backend.repository.ProductRepository;
import com.netcracker.edu.backend.service.CommentService;
import com.netcracker.edu.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProductServiceImpl implements ProductService {

    private ProductRepository repository;

    @Autowired
    public ProductServiceImpl(ProductRepository repository) {

        this.repository = repository;
    }

    @Override
    public Product saveProduct(Product product) {
        return this.repository.save(product);
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return this.repository.findById(id);
    }

    @Override
    public Iterable<Product> getAllProduct() {
        return this.repository.findAll();
    }

    @Override
    public void deleteProduct(Long id) {
        this.repository.deleteById(id);
    }
}
