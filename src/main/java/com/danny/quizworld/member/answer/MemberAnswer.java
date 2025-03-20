package com.danny.quizworld.member.answer;

import com.danny.quizworld.exam.answer.Answer;
import com.danny.quizworld.member.Member;
import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "t_member_answer")
public class MemberAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_answer_id")
    private Long memberAnswerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "answer_id")
    private Answer answer;

    @Builder
    public MemberAnswer(Member member, Answer answer) {
        this.member = member;
        this.answer = answer;
    }
}
