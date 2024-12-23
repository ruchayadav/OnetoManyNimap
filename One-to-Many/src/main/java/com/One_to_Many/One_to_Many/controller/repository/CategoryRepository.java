package com.One_to_Many.One_to_Many.controller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.One_to_Many.One_to_Many.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
