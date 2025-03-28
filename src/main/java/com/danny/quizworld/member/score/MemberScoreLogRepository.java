package com.danny.quizworld.member.score;

import com.danny.quizworld.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MemberScoreLogRepository extends JpaRepository<MemberScoreLog, Long> {
}
