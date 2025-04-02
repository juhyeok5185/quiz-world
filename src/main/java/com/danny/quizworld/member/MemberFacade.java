package com.danny.quizworld.member;

import com.danny.quizworld.common.config.MyException;
import com.danny.quizworld.common.response.UserDashBoardResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
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

    @Transactional
    public void updateNickname(MemberCommand.updateNickname request, Long memberId) {
        Long checkMember = memberService.countByNickname(request.getNickname());
        if(checkMember > 0){
            throw new MyException("같은 닉네임이 존재합니다.");
        }
        Member member = memberService.findById(memberId);
        member.updateNickname(request.getNickname());
        memberService.save(member);
    }
}
