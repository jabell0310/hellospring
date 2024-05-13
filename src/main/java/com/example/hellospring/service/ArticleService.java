package com.example.hellospring.service;

import com.example.hellospring.dto.Article;
import com.example.hellospring.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ArticleService {
    @Autowired
    ArticleRepository articleRepository;

    public Article createArticle(Article article) {
        return articleRepository.createArticle(article);
    }

    public ArrayList<Article> getAllArticles() {
        return articleRepository.getAllArticles();
    }

    public Article getArticle(String year) {
        return articleRepository.getArticle(year);
    }

    public void updateArticle(String year, Article article) {
        articleRepository.updateArticle(year, article);
    }

    public void deleteArticle(String year) {
        articleRepository.deleteArticle(year);
    }

}