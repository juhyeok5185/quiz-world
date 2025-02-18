package com.danny.quizworld.question;

import com.danny.quizworld.common.entity.BaseTimeEntity;
import com.danny.quizworld.subject.Subject;
import com.danny.quizworld.subject.chapter.Chapter;
import com.danny.quizworld.question.passage.Passage;
import lombok.AccessLevel;
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
    @Column(name = "quiz_id")
    private Long quizId; // 회원 일련번호

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
