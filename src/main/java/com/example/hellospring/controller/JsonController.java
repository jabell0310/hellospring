package com.example.hellospring.controller;

import com.example.hellospring.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JsonController {

    @GetMapping("/json")
    @ResponseBody
    public User userInfo() {
        return new User("김민준", 22);
    }

}
