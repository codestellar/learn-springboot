package com.itdc.books.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<com.itdc.books.entity.Category, Long> {
    // Basic CRUD methods are inherited automatically
}