package com.danny.quizworld.subject.chapter.question;

import com.danny.quizworld.common.entity.BaseTimeEntity;
import com.danny.quizworld.subject.Subject;
import com.danny.quizworld.subject.chapter.Chapter;
import com.danny.quizworld.subject.chapter.passage.Passage;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "t_question")
public class Question extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private Long passageId; // 회원 일련번호

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
    private String type;

    @Column(name = "text")
    private String text;
}
