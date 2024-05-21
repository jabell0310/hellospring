package com.example.hellospring.controller;

import com.example.hellospring.dto.Community;
import com.example.hellospring.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
public class ArticleController {
    @Autowired
    ArticleService articleService;

    @PostMapping("/articles")
    public Community createArticle(@RequestBody Community community) {
        return articleService.createCommunity(community);
    }

    @GetMapping("/articles")
    public ArrayList<Community> getAllArticles() {
        return articleService.getAllCommunities();
    }

    @GetMapping("/articles/{id}")
    public Community getArticle(@PathVariable String id) {
        return articleService.getCommunity(id);
    }

    @PutMapping("/articles/{id}")
    public Community updateArticle(@PathVariable String id,@RequestBody Community community) {
        return articleService.updateCommunity(id, community);
    }

    @DeleteMapping("/articles/{id}")
    public void deleteArticle(@PathVariable String id) {
        articleService.deleteCommunity(id);
    }
}