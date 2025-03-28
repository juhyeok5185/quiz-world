package com.danny.quizworld.member.score;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberScoreLogStore {

    private final MemberScoreLogRepository memberScoreLogRepository;

    public void save(MemberScoreLog memberScoreLog) {
        memberScoreLogRepository.save(memberScoreLog);
    }
}
