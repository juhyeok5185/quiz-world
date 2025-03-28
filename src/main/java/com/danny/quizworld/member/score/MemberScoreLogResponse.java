package com.danny.quizworld.member.score;

import com.danny.quizworld.member.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Builder
public class MemberScoreLogResponse {
    private Integer year;
    private Integer month;
    private Integer score;
}
