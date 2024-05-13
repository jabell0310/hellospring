package com.example.hellospring.controller;

import com.example.hellospring.dto.Article;
import com.example.hellospring.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/articles")
public class ArticleController {
    @Autowired
    ArticleService articleService;

    @PostMapping("")
    public Article createArticle(@RequestBody Article article) {
        return articleService.createArticle(article);
    }

    @GetMapping("")
    public ArrayList<Article> getAllArticles() {
        return articleService.getAllArticles();
    }

    @GetMapping("/{year}")
    public Article getArticle(@PathVariable String year) {
        return articleService.getArticle(year);
    }

    @PutMapping("/{year}")
    public void updateArticle(@PathVariable String year,@RequestBody Article article) {
        articleService.updateArticle(year, article);
    }

    @DeleteMapping("/{year}")
    public void deleteArticle(@PathVariable String year) {
        articleService.deleteArticle(year);
    }
}