package com.danny.quizworld.common.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @GetMapping("/user/{firstUrl}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String userFirstUrl(@PathVariable String firstUrl) {
        return "/user/" + firstUrl;
    }

    @GetMapping("/admin/{firstUrl}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String adminFirstUrl(@PathVariable String firstUrl) {
        return "/admin/" + firstUrl;
    }

}
