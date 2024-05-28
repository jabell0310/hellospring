package com.example.hellospring.controller;


import com.example.hellospring.model.Article;
import com.example.hellospring.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ArticleController {
    @Autowired
    ArticleService articleService;

    @PostMapping("/articles")
    public Article createArticle(@RequestBody Article article) {
        return articleService.createArticle(article);
    }


    @GetMapping("/articles")
    public List<Article> getAllBoardArticles(@RequestParam(name = "boardId", required = false) Integer board_id) {
        return articleService.getAllBoardArticles(board_id);
    }
    @GetMapping("/articles/{id}")
    public Article getArticle(@PathVariable String id) {
        return articleService.getArticle(id);
    }

    @PutMapping("/articles/{id}")
    public Article updateArticle(@PathVariable String id,@RequestBody Article article) {
        return articleService.updateArticle(article, id);
    }

    @DeleteMapping("/articles/{id}")
    public void deleteArticle(@PathVariable String id) {
        articleService.deleteArticle(id);
    }
}