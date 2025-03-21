package com.danny.quizworld.course.study;

import com.danny.quizworld.common.entity.BaseTimeEntity;
import com.danny.quizworld.course.chapter.Chapter;
import com.danny.quizworld.course.subject.Subject;
import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "t_study")
public class Study extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "study_id")
    private Long studyId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chapter_id")
    private Chapter chapter;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @Column(name = "type")
    private StudyType type; // 1: 단어, 2: 서술형

    @Column(name = "question_text")
    private String questionText;

    @Column(name = "answer_text")
    private String answerText;

    @Column(name = "description")
    private String description;

    @Builder
    public Study(Chapter chapter, Subject subject, StudyType type, String questionText, String answerText, String description) {
        this.chapter = chapter;
        this.subject = subject;
        this.type = type;
        this.questionText = questionText;
        this.answerText = answerText;
        this.description = description;
    }

    public void update(StudyCommand.update request) {
        this.questionText = request.getQuestionText();
        this.answerText = request.getAnswerText();
        this.description = request.getDescription();
        this.type = request.getType();
    }
}
