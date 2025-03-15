package com.OTONimap.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OTONimap.Entity.Category;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	
}
