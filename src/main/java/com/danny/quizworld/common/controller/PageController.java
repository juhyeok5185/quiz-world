package com.danny.quizworld.common.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Slf4j
@Controller
@RequiredArgsConstructor
public class PageController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/{firstUrl}")
    public String firstUrl(@PathVariable String firstUrl) {
        return firstUrl;
    }

    @GetMapping("/design/{firstUrl}")
    public String designFirstUrl(@PathVariable String firstUrl) {
        return "design/" + firstUrl;
    }

    @GetMapping("/user/{firstUrl}")
    public String userFirstUrl(@PathVariable String firstUrl) {
        return "user/" + firstUrl;
    }

    @GetMapping("/admin/{firstUrl}")
    public String adminFirstUrl(@PathVariable String firstUrl) {
        return "admin/" + firstUrl;
    }
}
