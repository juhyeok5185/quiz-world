package com.danny.quizworld.question;

import com.danny.quizworld.common.entity.BaseTimeEntity;
import com.danny.quizworld.subject.Subject;
import com.danny.quizworld.subject.chapter.Chapter;
import com.danny.quizworld.question.passage.Passage;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "t_question")
public class Question extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private Long questionId; // 회원 일련번호

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chapter_id")
    private Chapter chapter;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "passage_id")
    private Passage passage;

    @Column(name = "type")
    private QuestionType type;

    @Column(name = "question_text")
    private String questionText;

    @Column(name = "description")
    private String description;

    @Builder
    public Question(Chapter chapter, Subject subject, Passage passage, QuestionType type, String questionText , String description) {
        this.chapter = chapter;
        this.subject = subject;
        this.passage = passage;
        this.type = type;
        this.questionText = questionText;
        this.description = description;
    }


    public void updateQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public void updateByUpdateRequest(QuestionRequest request) {
        this.type = request.getType();
        this.questionText = request.getQuestionText();
        this.description = request.getDescription();
    }
}
