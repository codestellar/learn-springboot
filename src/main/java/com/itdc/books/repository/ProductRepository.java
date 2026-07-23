package com.itdc.books.repository;

import com.itdc.books.entity.Product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Basic CRUD methods are inherited automatically

@Query(value = "SELECT * FROM product WHERE price >= :minPrice", nativeQuery = true)
    List<Product> findProductByPriceMoreThan(@Param("minPrice") double minPrice);
}