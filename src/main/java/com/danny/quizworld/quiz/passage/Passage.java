package com.danny.quizworld.quiz.passage;

import com.danny.quizworld.common.entity.BaseTimeEntity;
import com.danny.quizworld.course.subject.Subject;
import com.danny.quizworld.course.chapter.Chapter;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "t_passage")
public class Passage extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "passage_id")
    private Long passageId; // 회원 일련번호

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chapter_id")
    private Chapter chapter;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @Column(name = "name")
    private String text;

    @Builder
    public Passage(Chapter chapter, Subject subject, String text) {
        this.chapter = chapter;
        this.subject = subject;
        this.text = text;
    }
}
