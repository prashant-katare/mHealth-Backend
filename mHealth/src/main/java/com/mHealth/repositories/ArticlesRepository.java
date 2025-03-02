package com.mHealth.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mHealth.entities.Articles;

@Repository
public interface ArticlesRepository extends JpaRepository<Articles, Long> {

	Articles findByArticleId(Long aticleId);

	List<Articles> findAllByCategoryId(Long categoryId);
}
