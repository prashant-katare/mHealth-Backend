package com.mHealth.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mHealth.entities.Articles;
import com.mHealth.entities.Category;
import com.mHealth.entities.Recommended;
import com.mHealth.models.AllArticles;
import com.mHealth.services.ArticleService;

@RestController
public class ArticleController {

	private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);

	@Autowired
	private ArticleService articleService;

	@GetMapping("/")
	String getData() {
		logger.info("Health check endpoint accessed");
		return "Application running...";
	}

	@GetMapping("/article/{articleId}")
	Articles getArticleByArticaleId(@PathVariable("articleId") Long articleId) {
		logger.info("Request received for article with ID: {}", articleId);
		Articles article = articleService.getArticleByArticleId(articleId);
		logger.info("Successfully retrieved article with ID: {}", articleId);
		return article;
	}

	@GetMapping("/allArticlesByCategory/{categoryId}")
	AllArticles getAllArticleByCategoryId(@PathVariable("categoryId") Long categoryId) {
		logger.info("Request received for all articles in category ID: {}", categoryId);
		AllArticles articles = articleService.getAllArticlesByCategoryId(categoryId);
		logger.info("Successfully retrieved articles for category ID: {}", categoryId);
		return articles;
	}

	@GetMapping("/allArticles")
	AllArticles[] getAllArticles() {
		logger.info("Request received for all articles");
		AllArticles[] articles = articleService.getAllArticles();
		logger.info("Successfully retrieved all articles");
		return articles;
	}

	@GetMapping("/allRecommendedArticles")
	List<Recommended> getAllRecommendedArticles() {
		logger.info("Request received for all recommended articles");
		List<Recommended> recommendedArticles = articleService.getAllRecommendedArticles();
		logger.info("Successfully retrieved recommended articles, count: {}",
				recommendedArticles != null ? recommendedArticles.size() : 0);
		return recommendedArticles;
	}

	@GetMapping("/allCategories")
	List<Category> getAllCategories() {
		logger.info("Request received for all categories");
		List<Category> categories = articleService.getAllCategories();
		logger.info("Successfully retrieved categories, count: {}",
				categories != null ? categories.size() : 0);
		return categories;
	}
}
