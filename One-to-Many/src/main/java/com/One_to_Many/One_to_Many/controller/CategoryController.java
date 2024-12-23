package com.One_to_Many.One_to_Many.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.One_to_Many.One_to_Many.controller.service.CategoryService;
import com.One_to_Many.One_to_Many.entity.Category;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllCategories(@RequestParam int page, @RequestParam(defaultValue = "5") int size) {
        // Check if the page is valid
        Page<Category> categoryPage = categoryService.getAllCategories(page, size);

        // Return 404 if no data is found for the requested page
        if (categoryPage.getContent().isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        // Prepare the response with metadata and content
        Map<String, Object> response = new HashMap<>();
        response.put("categories", categoryPage.getContent());
        response.put("totalItems", categoryPage.getTotalElements());
        response.put("totalPages", categoryPage.getTotalPages());
        response.put("currentPage", categoryPage.getNumber());

        return ResponseEntity.ok(response);
    }



    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Category createCategory(@RequestBody Category category) {
        return categoryService.createCategory(category);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category updatedCategory) {
        try {
            return ResponseEntity.ok(categoryService.updateCategory(id, updatedCategory));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
