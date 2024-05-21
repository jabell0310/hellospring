package com.example.hellospring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Member {
    private Integer id;

    private String name;

    private String email;

    private String password;



}
