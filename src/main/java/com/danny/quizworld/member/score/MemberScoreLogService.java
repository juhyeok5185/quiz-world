package com.danny.quizworld.member.score;

import com.danny.quizworld.common.response.UserDashBoardResponse;
import com.danny.quizworld.member.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberScoreLogService {

    private final MemberScoreLogReader memberScoreLogReader;
    private final MemberScoreLogStore memberScoreLogStore;
    private final MemberScoreLogMapper memberScoreLogMapper;


    public MemberScoreLog toEntity(Member member, Integer year, Integer month) {
        return memberScoreLogMapper.toEntity(member , year , month);
    }

    @Transactional
    public void save(MemberScoreLog memberScoreLog) {
        memberScoreLogStore.save(memberScoreLog);
    }
}
