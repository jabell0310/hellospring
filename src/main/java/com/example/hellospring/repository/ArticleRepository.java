package com.example.hellospring.repository;


import com.example.hellospring.model.Article;


import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Repository
public class ArticleRepository {

    static public ArrayList<Article> articles;

    static {
        articles = new ArrayList<>();
        articles.add(new Article(1, 1,1,"Sekiro", LocalDateTime.of(2019,12,12,12,0,0)));
        articles.add(new Article(2, 2,2,"Hades", LocalDateTime.of(2020,12,11,12,0,0)));
        articles.add(new Article(3, 3,3,"It takes two", LocalDateTime.of(2021,12,10,12,0,0)));
        articles.add(new Article(4, 1,4,"Elden Ring", LocalDateTime.of(2022,12,8,12,0,0)));
        articles.add(new Article(5, 4,5,"Baldur's gate 3", LocalDateTime.of(2023,12,7,12,0,0)));
    }

    public Article create(Article article) {
        articles.add(article);
        return article;
    }

    public ArrayList<Article> findAll() {
        return articles;
    }

    public Article findById(String id) {
        return articles.stream()
                .filter(Article -> Article.getId().equals(Integer.parseInt(id)))
                .findAny()
                .orElse(new Article(null,null,null, "",null));
    }

    public void updateContent(String id, String content) {
        articles.stream()
                .filter(Community -> Community.getId().equals(Integer.parseInt(id)))
                .findAny()
                .orElse(new Article(null,null,null,"",null))
                .setContents(content);

    }

    public void delete(String id) {
        articles.removeIf(Article -> Article.getId().equals(Integer.parseInt(id)));
    }
}