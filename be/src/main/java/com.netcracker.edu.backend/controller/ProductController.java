package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.Product;
import com.netcracker.edu.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)//сопоставление запросов
    public ResponseEntity<Product> getProductById(@PathVariable(name = "id") Long id){//RequestBody, RequestParametr
        Optional<Product> product = productService.getProductById(id);
        if(product.isPresent()){
            return ResponseEntity.ok(product.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }//ответ

    @RequestMapping(value = "", method = RequestMethod.GET)//сопоставление запросов
    public Iterable<Product> getAllProduct(){
        return productService.getAllProduct();
    }//ответ

    @RequestMapping(method = RequestMethod.POST)//сопоставление запросов
    public Product saveProduct(@RequestBody Product product){
        return this.productService.saveProduct(product);
    }//ответ

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)//сопоставление запросов
    public ResponseEntity deleteProductById(@PathVariable(name = "id") Long id){
        this.productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }//ответ

    @RequestMapping(value = "/page" , method = RequestMethod.GET)
    public Page<Product> getPage(@PageableDefault( sort = {"productId"}, direction = Sort.Direction.DESC) Pageable pageable) {
        return this.productService.getProductPage(pageable);
    }

    @RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
    public Iterable<Product> getProductByCategoryId(@PathVariable(name = "id") Integer id) {
        return this.productService.getProductByCategoryId(id);
    }
}
