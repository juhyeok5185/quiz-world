//package com.danny.quizworld;
//
//import com.danny.quizworld.common.util.Utils;
//import com.danny.quizworld.member.Member;
//import com.danny.quizworld.member.MemberService;
//import com.danny.quizworld.member.score.MemberScoreLog;
//import com.danny.quizworld.member.score.MemberScoreLogService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest
//public class ScheduledTasksFacadeTest {
//
//    @Autowired
//    private MemberService memberService;
//    @Autowired
//    private MemberScoreLogService memberScoreLogService;
//
//    @Test
//    void triggerAtMidnight01OfEveryMonth(){
//        Member member = memberService.findById(1L);
//        Integer year = Utils.getLastMonthYear();
//        Integer month = Utils.getLastMonth();
//        MemberScoreLog memberScoreLog = memberScoreLogService.toEntity(member , year , month);
//        memberScoreLogService.save(memberScoreLog);
//        member.initScore();
//        memberService.save(member);
//    }
//}
