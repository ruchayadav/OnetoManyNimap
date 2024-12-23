package com.One_to_Many.One_to_Many.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.One_to_Many.One_to_Many.controller.service.ProductService;
import com.One_to_Many.One_to_Many.entity.Category;
import com.One_to_Many.One_to_Many.entity.Product;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

//    @GetMapping
//    public Page<Product> getAllProducts(Pageable pageable) {
//        return productService.getAllProducts(pageable);
//    }

  @GetMapping
  public Page<Product> getAllProducts(@RequestParam int page ) {
      return productService.getAllProducts(page , 5);
  }


    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return productService.getProductById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
        try {
            return ResponseEntity.ok(productService.updateProduct(id, updatedProduct));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}