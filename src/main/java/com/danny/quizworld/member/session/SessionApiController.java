package com.danny.quizworld.member.session;

import com.danny.quizworld.common.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members/sessions")
public class SessionApiController {

    private final SessionService sessionService;

    @PostMapping
    public ResponseEntity<ApiResponse<String>> login(@RequestBody SessionRequest request,
                                                     HttpServletRequest httpServletRequest) {

        return null;
    }



}
