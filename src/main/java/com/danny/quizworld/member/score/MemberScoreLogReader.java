package com.danny.quizworld.member.score;

import com.danny.quizworld.common.config.MyException;
import com.danny.quizworld.member.Member;
import com.danny.quizworld.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MemberScoreLogReader {

    private final MemberScoreLogRepository memberScoreLogRepository;


}
