package com.danny.quizworld.common.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class PageController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/{firstUrl}")
    public String firstUrl(@PathVariable String firstUrl) {
        return "/" + firstUrl;
    }

}
