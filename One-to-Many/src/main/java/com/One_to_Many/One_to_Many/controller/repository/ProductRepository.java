package com.One_to_Many.One_to_Many.controller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.One_to_Many.One_to_Many.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}