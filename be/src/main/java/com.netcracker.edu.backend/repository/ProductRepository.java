package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends
        JpaRepository<Product, Long> {
    @Query("select p.cost from Product p where p.productId = :id")
    int getCost(@Param("id")Long id);
}