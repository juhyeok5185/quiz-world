package com.danny.quizworld.member;

import com.danny.quizworld.common.response.ApiResponse;
import com.danny.quizworld.common.util.Utils;
import com.danny.quizworld.course.chapter.ChapterResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
public class MemberApiController {

    private final MemberFacade memberFacade;

    @GetMapping
    public ResponseEntity<ApiResponse<MemberResponse>> findByIdToResponse(Authentication authentication) {
        Long memberId = Utils.getMemberId(authentication);
        return ResponseEntity.ok(new ApiResponse<>(memberFacade.findByIdToResponse(memberId)));
    }
}
