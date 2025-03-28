package com.danny.quizworld.schedule;

import com.danny.quizworld.common.util.Utils;
import com.danny.quizworld.member.Member;
import com.danny.quizworld.member.MemberService;
import com.danny.quizworld.member.score.MemberScoreLog;
import com.danny.quizworld.member.score.MemberScoreLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduledTasksFacade {

    private final MemberService memberService;
    private final MemberScoreLogService memberScoreLogService;

    @Transactional
    public void expiredSubscribe() {
        List<Member> memberList = memberService.findAllBySubscribeYnTrue();
        //todo member가 같고 , use_yn 이 ture 인 memberSubscribe 를 찾아서
        // 1. endtime이 지났으면 memberSubscribe use_yn false , member subscribeYn = false
        // 2. endtime이 안지났으면 continue
    }

    @Transactional
    public void triggerAtMidnight01OfEveryMonth() {
        List<Member> memberList = memberService.findAll();
        memberList.forEach(member -> {
            Integer year = Utils.getLastMonthYear();
            Integer month = Utils.getLastMonth();
            MemberScoreLog memberScoreLog = memberScoreLogService.toEntity(member , year , month);
            memberScoreLogService.save(memberScoreLog);
            member.initScore();
            memberService.save(member);
        });
    }
}
