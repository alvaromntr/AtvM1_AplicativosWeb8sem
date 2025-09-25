package com.example.crud.domain.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, String> {
    List<Product> findAllByActiveTrue();

    @Query("SELECT p FROM product p WHERE p.category = :category AND p.active = true")
    List<Product> findAllByCategory(@Param("category") String category);

    List<Product> findAllByCategoryAndActiveTrue(String category);

}