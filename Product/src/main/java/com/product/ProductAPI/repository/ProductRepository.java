package com.product.ProductAPI.repository;

import com.product.ProductAPI.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("SELECT e FROM Product e WHERE e.name = :name")
    Product findbyName(@Param("name") String name);

}
