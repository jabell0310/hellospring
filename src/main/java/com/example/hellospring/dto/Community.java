package com.example.hellospring.dto;

import com.example.hellospring.model.Article;
import com.example.hellospring.model.Board;
import com.example.hellospring.model.Member;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDateTime;

@Getter
@Setter
public class Community {

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Integer id;
    private String title;
    private String author;
    private LocalDateTime date;
    private String content;

    public Community(Article article, Member member, Board board) {
        this.id = article.getId();
        this.title = board.getTitle();
        this.author = member.getName();
        this.date = article.getCreateTime();
        this.content = article.getContents();
    }
}
