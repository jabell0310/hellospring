package com.example.hellospring.service;

import com.example.hellospring.dto.Community;
import com.example.hellospring.model.Article;
import com.example.hellospring.model.Board;
import com.example.hellospring.model.Member;
import com.example.hellospring.repository.ArticleRepository;
import com.example.hellospring.repository.BoardRepository;
import com.example.hellospring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Locale;

@Service
public class ArticleService {
    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    MemberRepository memberRepository;


    ArrayList<Community> communityDTOs = new ArrayList<>();

    public Community createCommunity(Community community) {
        getAllCommunities();
        Board board = new Board(community.getId(), community.getTitle());
        Member member = new Member(null, community.getAuthor(), community.getAuthor().toLowerCase(Locale.ROOT) +"@gmail.com", "");
        Article article = new Article(community.getId(), null ,community.getId(), community.getContent(), LocalDateTime.now());
        Community newCommunity = new Community(articleRepository.create(article),memberRepository.create(member),boardRepository.create(board));
        communityDTOs.add(newCommunity);
        return newCommunity;
    }

    public ArrayList<Community> getAllCommunities() {
        ArrayList<Article> articles = articleRepository.findAll();


        for (Article article : articles) {
            Member member = memberRepository.findById(String.valueOf(article.getUserId()));
            Board board = boardRepository.findById(String.valueOf(article.getBoardId()));

            communityDTOs.add(new Community(article, member, board));
        }

        return communityDTOs;
    }

    public Community getCommunity(String id) {
        Article article = articleRepository.findById(id);
        Member member = memberRepository.findById(String.valueOf(article.getUserId()));
        Board board = boardRepository.findById(String.valueOf(article.getBoardId()));
        return new Community(article,member,board);
    }

    public Community updateCommunity(String id, Community community) {
        Article article = articleRepository.findById(id);
        Member member = memberRepository.findById(String.valueOf(article.getUserId()));
        Board board = boardRepository.findById(String.valueOf(article.getBoardId()));
        articleRepository.updateContent(id, article);
        memberRepository.updateName(String.valueOf(article.getUserId()), member);
        boardRepository.updateTitle(String.valueOf(article.getBoardId()),board);
        return community;
    }

    public void deleteCommunity(String id) {
        articleRepository.delete(id);
        memberRepository.delete(id);
        boardRepository.delete(id);
    }

}