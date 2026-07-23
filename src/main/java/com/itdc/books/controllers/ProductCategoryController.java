package com.itdc.books.controllers;

import com.itdc.books.entity.Category;
import com.itdc.books.entity.Product;
import com.itdc.books.repository.CategoryRepository;
import com.itdc.books.repository.ProductRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class ProductCategoryController {

    private final CategoryRepository categoryRepository;

    // Constructor injection for clean architecture and easier testing
    public ProductCategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    // 1. CREATE
    @PostMapping
    public ResponseEntity<Category> createProduct(@RequestBody Category category) {
        return ResponseEntity.ok(categoryRepository.save(category));
    }

    // 2. READ ALL
    @GetMapping
    public List<Category> getAllProducts() {
        return categoryRepository.findAll();
    }

    // 3. READ ONE BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Category> getProductById(@PathVariable Long id) {
        return categoryRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 5. DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
            return ResponseEntity.noContent().build(); // HTTP 204
        }
        return ResponseEntity.notFound().build(); // HTTP 404
    }
}