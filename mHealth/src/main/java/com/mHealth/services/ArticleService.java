package com.mHealth.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mHealth.entities.Articles;
import com.mHealth.entities.Category;
import com.mHealth.entities.Recommended;
import com.mHealth.models.AllArticles;
import com.mHealth.repositories.ArticlesRepository;
import com.mHealth.repositories.CategoryRepository;
import com.mHealth.repositories.RecommendedRepository;

@Service
public class ArticleService {

    @Autowired
    private ArticlesRepository articlesRepository;

    @Autowired
    private RecommendedRepository recommendedRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public Articles getArticleByArticleId(Long articleId) {
        return articlesRepository.findByArticleId(articleId);
    }

    public AllArticles getAllArticlesByCategoryId(Long categoryId) {
        AllArticles allArticles = new AllArticles();

        Category category = categoryRepository.findByCategoryId(categoryId);
        List<Articles> articles = articlesRepository.findAllByCategoryId(categoryId);

        allArticles.setCategoryName(category.getCategoryName());
        allArticles.setCategoryId(category.getCategoryId());
        allArticles.setArticles(articles);

        return allArticles;
    }

    public AllArticles[] getAllArticles() {
        List<Category> allCategories = categoryRepository.findAll();

        AllArticles[] allArticles = new AllArticles[allCategories.size()];

        int i = 0;

        for (Category category : allCategories) {
            AllArticles obj = new AllArticles();
            obj.setCategoryName(category.getCategoryName());
            obj.setCategoryId(category.getCategoryId());
            obj.setArticles(articlesRepository.findAllByCategoryId(category.getCategoryId()));
            allArticles[i] = obj;
            i++;
        }
        return allArticles;
    }

    public List<Recommended> getAllRecommendedArticles() {
        return recommendedRepository.findAll();
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}