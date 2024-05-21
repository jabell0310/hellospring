package com.example.hellospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HellospringApplication {

	public static void main(String[] args) {
		SpringApplication.run(HellospringApplication.class, args);
	}

	/*
	TODO 0. Controller에서 Service로 유저가 입력한 정보를 넘길때에는 Community DTO를 이용하거나, Request 전용 Community DTO를 만들어 요청한다.

	TODO 1. Model 별로 Repository를 분리시킨다.
		- ArticleRepository
		- BoardRepo...
		- MemberRepo...

	TODO 2. CommunityService를 만든다.
		- 위에서 만든 3가지 Repository를 가져온다.
		- 불러온 3가지 레포지토리를 이용하여 Community DTO를 만든다.
		- Controller에 Community DTO를 반환해준다.

	 */
}
