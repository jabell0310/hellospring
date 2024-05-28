package com.example.hellospring.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;


@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Article {

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Integer author_id;

    @Column
    private Integer board_id;

    @Column
    private String title;

    @Column
    private String content;

    @Column
    private Timestamp created_date;

    @Column
    private Timestamp modified_date;
    

}