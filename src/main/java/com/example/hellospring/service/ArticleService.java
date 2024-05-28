package com.example.hellospring.service;

import com.example.hellospring.dao.ArticleDaoImpl;
import com.example.hellospring.dao.BoardDaoImpl;
import com.example.hellospring.dao.MemberDaoImpl;

import com.example.hellospring.model.Article;
import com.example.hellospring.model.Board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;


@Service
public class ArticleService {

    @Autowired
    ArticleDaoImpl articleDao;

    @Autowired
    BoardDaoImpl boardDao;

    @Autowired
    MemberDaoImpl memberDao;


    @Transactional
    public Article createArticle(Article article) {
        article.setCreated_date(Timestamp.valueOf(LocalDateTime.now()));
        articleDao.createArticle(article);
        return article;
    }


    @Transactional(readOnly = true)
    public List<Article> getAllBoardArticles(Integer board_id) {
        if (board_id == null) {
            return articleDao.allArticles();
        }
        return articleDao.allBoardArticles(board_id);
    }


    @Transactional(readOnly = true)
    public Article getArticle(String id) {
        return articleDao.getById(Integer.parseInt(id));
    }


    @Transactional(readOnly = true)
    public Board getBoard(int id) {
        return boardDao.getById(id);
    }


    @Transactional
    public Article updateArticle(Article article, String id) {
        return articleDao.updateArticle(article, id);

    }


    @Transactional
    public void deleteArticle(String id) {
        articleDao.deleteById(Integer.parseInt(id));
    }


}