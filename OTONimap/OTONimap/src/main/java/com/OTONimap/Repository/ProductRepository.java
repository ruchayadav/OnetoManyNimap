package com.OTONimap.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OTONimap.Entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
}


