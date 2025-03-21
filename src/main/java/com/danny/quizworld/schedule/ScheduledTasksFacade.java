package com.danny.quizworld.schedule;

import com.danny.quizworld.member.Member;
import com.danny.quizworld.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduledTasksFacade {

    private final MemberService memberService;

    public void expiredSubscribe() {
        List<Member> memberList = memberService.findAllBySubscribeYnTrue();
        //todo member가 같고 , use_yn 이 ture 인 memberSubscribe 를 찾아서
        // 1. endtime이 지났으면 memberSubscribe use_yn false , member subscribeYn = false
        // 2. endtime이 안지났으면 continue
    }
}
