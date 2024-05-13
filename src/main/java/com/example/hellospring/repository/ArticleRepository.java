package com.example.hellospring.repository;

import com.example.hellospring.dto.Article;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class ArticleRepository {

    static public ArrayList<Article> articles;

    static {
        articles = new ArrayList<>();
        articles.add(new Article(2020,"Hades","Goty of 2020"));
        articles.add(new Article(2021,"Ittakestwo","Goty of 2021"));
        articles.add(new Article(2022,"EldenRing","Goty of 2022"));
    }

    public Article createArticle(Article article) {
        articles.add(article);
        return article;
    }

    public ArrayList<Article> getAllArticles() {
        return articles;
    }

    public Article getArticle(String year) {
        return articles.stream()
                .filter(Article -> Article.getYear().equals(Integer.parseInt(year)))
                .findAny()
                .orElse(new Article(null, "", ""));
    }

    public void updateArticle(String year, Article article) {
        articles.stream()
                .filter(Article -> Article.getYear().equals(Integer.parseInt(year)))
                .findAny()
                .orElse(new Article(null, "", ""))
                .setName(article.getName());
    }

    public void deleteArticle(String year) {
        articles.removeIf(Article -> Article.getYear().equals(Integer.parseInt(year)));
    }
}