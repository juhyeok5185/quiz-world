package com.danny.quizworld.quiz.answer;

import com.danny.quizworld.common.entity.BaseTimeEntity;
import com.danny.quizworld.quiz.question.Question;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "t_answer")
public class Answer extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answer_id")
    private Long answerId; // 회원 일련번호

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;

    @Column(name = "answer_yn")
    private Boolean answerYn;

    @Column(name = "answer_text")
    private String answerText;

    @Builder
    public Answer(Question question, Boolean answerYn, String answerText) {
        this.question = question;
        this.answerYn = answerYn;
        this.answerText = answerText;
    }

    public void updateAnswerText(String answerText) {
        this.answerText = answerText;
    }
}
