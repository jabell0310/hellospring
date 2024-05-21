package com.example.hellospring.controller;

import com.example.hellospring.dto.Community;
import com.example.hellospring.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@Controller
public class ArticleController {
    @Autowired
    ArticleService articleService;

    @GetMapping("/posts")
    public String article(Model model) {
        ArrayList<Community> articles = articleService.getAllCommunities();
        model.addAttribute("articles", articles);
        return "article";
    }
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