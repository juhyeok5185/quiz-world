package com.danny.quizworld.member;

import com.danny.quizworld.common.response.ApiResponse;
import com.danny.quizworld.common.response.UserDashBoardResponse;
import com.danny.quizworld.common.util.Utils;
import com.danny.quizworld.course.chapter.ChapterResponse;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
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

    @GetMapping("/dashboard")
    public ResponseEntity<ApiResponse<UserDashBoardResponse>> findUserDashBoardResponseByMemberId(Authentication authentication) {
        Long memberId = Utils.getMemberId(authentication);
        return ResponseEntity.ok(new ApiResponse<>(memberFacade.findUserDashBoardResponseByMemberId(memberId)));
    }

    @PatchMapping
    public ResponseEntity<ApiResponse<MemberResponse>> addScore(Authentication authentication){
        Long memberId = Utils.getMemberId(authentication);
        memberFacade.addScore(memberId);
        return ResponseEntity.status(201).body(new ApiResponse<>("score 추가" , 201 , null));
    }

    @PatchMapping("/nickname")
    public ResponseEntity<ApiResponse<MemberResponse>> updateNickname(@RequestBody MemberCommand.updateNickname request, Authentication authentication){
        Long memberId = Utils.getMemberId(authentication);
        memberFacade.updateNickname(request, memberId);
        return ResponseEntity.status(201).body(new ApiResponse<>("Nickname 변경" , 201 , null));
    }

    @DeleteMapping
    public ResponseEntity<ApiResponse<MemberResponse>> deleteMember(Authentication authentication){
        Long memberId = Utils.getMemberId(authentication);
        memberFacade.deleteMember(memberId);
        return ResponseEntity.status(201).body(new ApiResponse<>("Member 삭제" , 201 , null));
    }
}
