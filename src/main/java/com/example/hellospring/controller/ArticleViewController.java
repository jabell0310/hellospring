package com.example.hellospring.controller;

import com.example.hellospring.model.Article;
import com.example.hellospring.model.Board;

import com.example.hellospring.service.ArticleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ArticleViewController {

    @Autowired
    ArticleService articleService;


    @GetMapping("/posts")
    public String article(@RequestParam(name = "boardId", required = false) int id, Model model) {

        List<Article> articles = articleService.getAllBoardArticles(id);
        Board board = articleService.getBoard(id);

        model.addAttribute("boardName", board);
        model.addAttribute("articles", articles);

        return "article";
    }
}
