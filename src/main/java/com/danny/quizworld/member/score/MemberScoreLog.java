package com.danny.quizworld.member.score;

import com.danny.quizworld.common.entity.BaseTimeEntity;
import com.danny.quizworld.course.chapter.Chapter;
import com.danny.quizworld.member.Member;
import com.danny.quizworld.member.MemberRole;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "t_member_score_log")
public class MemberScoreLog extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_score_log_id")
    private Long memberScoreLogId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "year")
    private Integer year;

    @Column(name = "month")
    private Integer month;

    @Column(name = "score")
    private Integer score;

    @Builder
    public MemberScoreLog(Member member, Integer year, Integer month, Integer score) {
        this.member = member;
        this.year = year;
        this.month = month;
        this.score = score;
    }

}
