package com.danny.quizworld.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberFacade {
    private final MemberService memberService;

    public MemberResponse save(MemberSaveRequest request){
        Member member = memberService.toEntity(request);
        return memberService.toResponse(memberService.save(member));
    }
}
