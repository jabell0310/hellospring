package com.example.hellospring.dao;

import com.example.hellospring.model.Article;

import java.util.List;

public interface ArticleDao {
    void createArticle(Article article);

    List<Article> allArticles();

    List<Article> allBoardArticles(int board_id);

    Article getById(int id);

    Article updateArticle(Article article, String id);

    void deleteById(int id);
}
