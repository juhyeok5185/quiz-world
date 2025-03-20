package com.danny.quizworld.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberFacade {
    private final MemberService memberService;

    public MemberResponse findByIdToResponse(Long memberId) {
        return memberService.toResponse(memberService.findById(memberId));
    }
}
