package com.danny.quizworld.subject;

import com.danny.quizworld.common.response.ApiResponse;
import com.danny.quizworld.common.util.Utils;
import lombok.RequiredArgsConstructor;
import org.checkerframework.checker.units.qual.A;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subjects")
@RequiredArgsConstructor
public class SubjectApiController {

    private final SubjectFacade subjectFacade;

    @PostMapping
    public ResponseEntity<ApiResponse<SubjectResponse>> save(Authentication authentication, @RequestBody String name){
        Long memberId = Utils.getAuthId(authentication);
        return ResponseEntity.status(201).body(new ApiResponse<>(subjectFacade.save(memberId,name)));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<SubjectResponse>>> findAllByMemberId(Authentication authentication){
        Long memberId = Utils.getAuthId(authentication);
        return ResponseEntity.ok(new ApiResponse<>(subjectFacade.findAllByMemberId(memberId)));
    }
}
