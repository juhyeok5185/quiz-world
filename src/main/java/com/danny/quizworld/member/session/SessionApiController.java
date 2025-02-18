package com.danny.quizworld.member.session;

import com.danny.quizworld.common.response.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members/sessions")
public class SessionApiController {

    private final SessionService sessionService;

    @PostMapping
    public void login() {
        System.out.println("Dd");
        System.out.println("Dd");
        System.out.println("Dd");
        System.out.println("Dd");
        System.out.println("Dd");
        System.out.println("Dd");
    }



}
