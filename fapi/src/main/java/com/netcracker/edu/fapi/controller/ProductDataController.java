package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.entity.ProductViewModel;
import com.netcracker.edu.fapi.service.ProductDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductDataController {

    @Autowired
    private ProductDataService productDataService;

    @RequestMapping
    public ResponseEntity<List<ProductViewModel>> getAllProduct() {

        return ResponseEntity.ok(productDataService.getAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ProductViewModel> saveProduct(@RequestBody ProductViewModel product /*todo server validation*/) {
        if (product != null) {
            return ResponseEntity.ok(productDataService.saveProduct(product));
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable String id) {
        productDataService.deleteProduct(Long.valueOf(id));
    }
}