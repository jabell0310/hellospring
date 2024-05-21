package com.example.hellospring.controller;

import com.example.hellospring.dto.Community;
import com.example.hellospring.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class ArticleViewController {
    @Autowired
    ArticleService articleService;

    @GetMapping("/posts")
    public String article(Model model) {
        ArrayList<Community> articles = articleService.getAllCommunities();
        model.addAttribute("articles", articles);
        return "article";
    }
}
