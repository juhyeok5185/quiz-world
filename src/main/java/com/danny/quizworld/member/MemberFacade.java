package com.danny.quizworld.member;

import com.danny.quizworld.common.response.UserDashBoardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberFacade {
    private final MemberService memberService;

    @Transactional(readOnly = true)
    public MemberResponse findByIdToResponse(Long memberId) {
        return memberService.toResponse(memberService.findById(memberId));
    }

    @Transactional
    public void addScore(Long memberId) {
        Member member = memberService.findById(memberId);
        member.addScore();
        memberService.save(member);
    }

    @Transactional(readOnly = true)
    public UserDashBoardResponse findUserDashBoardResponseByMemberId(Long memberId) {
        UserDashBoardResponse response = memberService.findUserDashBoardResponseByMemberId(memberId);
        response.decryptName();
        return response;
    }
}
