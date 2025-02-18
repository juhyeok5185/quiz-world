package com.danny.quizworld.member.session;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members/sessions")
public class SessionApiController {

    private final SessionService sessionService;

    @PostMapping
    public void login() {

    }



}
