package com.danny.quizworld.exam.answer;

import com.danny.quizworld.common.entity.BaseTimeEntity;
import com.danny.quizworld.exam.question.Question;
import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "t_exam_answer")
public class Answer extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answer_id")
    private Long answerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;

    @Column(name = "answer_text")
    private String answerText;

    @Column(name = "answer_yn")
    private Boolean answerYn; // 정답 여부

    @Builder
    public Answer(Question question, String answerText, Boolean answerYn) {
        this.question = question;
        this.answerText = answerText;
        this.answerYn = answerYn;
    }
}
