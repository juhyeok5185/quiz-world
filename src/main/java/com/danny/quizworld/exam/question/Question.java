package com.danny.quizworld.exam.question;

import com.danny.quizworld.common.entity.BaseTimeEntity;
import com.danny.quizworld.course.chapter.Chapter;
import com.danny.quizworld.course.subject.Subject;
import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "t_exam_question")
public class Question extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private Long questionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chapter_id")
    private Chapter chapter;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @Column(name = "question_text")
    private String questionText;

    @Column(name = "description")
    private String description;

    @Builder
    public Question(Chapter chapter, Subject subject, String questionText, String description) {
        this.chapter = chapter;
        this.subject = subject;
        this.questionText = questionText;
        this.description = description;
    }
}
