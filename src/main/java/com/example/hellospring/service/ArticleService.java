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
        int memberId = memberRepository.findIdByName(community.getAuthor());
        Integer newId = communityDTOs.size() + 1;
        Board board = new Board(newId, community.getTitle());
        Member member = new Member(memberId, community.getAuthor(), community.getAuthor().toLowerCase(Locale.ROOT) +"@gmail.com", "");
        Article article = new Article(newId, memberId,newId, community.getContent(), LocalDateTime.now());
        Community newCommunity = new Community(articleRepository.create(article),memberRepository.create(member),boardRepository.create(board));
        communityDTOs.add(newCommunity);
        return newCommunity;
    }

    public ArrayList<Community> getAllCommunities() {
        communityDTOs.clear();
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
        getAllCommunities();
        Article article = articleRepository.findById(id);
        articleRepository.updateContent(id, community.getContent());
        memberRepository.updateName(String.valueOf(article.getUserId()), community.getAuthor());
        boardRepository.updateTitle(id, community.getTitle());
        communityDTOs.set(Integer.parseInt(id)-1, community);
        return community;
    }

    public void deleteCommunity(String id) {
        articleRepository.delete(id);
        memberRepository.delete(id);
        boardRepository.delete(id);
    }

}