package com.mHealth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mHealth.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	
	Category findByCategoryId(Long categoryId);
}
