package com.example.hellospring.model;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Article {
    private Integer id;
    private Integer userId;
    private Integer boardId;
    private String title;
    private String contents;
    private LocalDateTime createTime;
    private LocalDateTime editTime = LocalDateTime.now();
    public Article(Integer id, Integer userId, Integer boardId, String contents, LocalDateTime createTime) {
        this.id = id;
        this.userId = userId;
        this.boardId = boardId;
        this.contents = contents;
        this.createTime = createTime;
    }


}