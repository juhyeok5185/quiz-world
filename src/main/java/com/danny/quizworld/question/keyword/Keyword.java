package com.danny.quizworld.question.keyword;

import com.danny.quizworld.common.entity.BaseTimeEntity;
import com.danny.quizworld.member.Member;
import com.danny.quizworld.member.MemberRole;
import com.danny.quizworld.question.Question;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "t_question_keyword")
public class Keyword extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_keyword_id")
    private Long keywordId; // 회원 일련번호

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;

    @Column(name = "name")
    private String name;

    @Builder
    public Keyword(Question question, String name) {
        this.question = question;
        this.name = name;
    }
}
