package com.danny.quizworld.course.chapter;

import com.danny.quizworld.common.entity.BaseTimeEntity;
import com.danny.quizworld.course.subject.Subject;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "t_chapter")
public class Chapter extends BaseTimeEntity {
//
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chapter_id")
    private Long chapterId; // 회원 일련번호

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @Column(name = "name")
    private String name;

    @Builder
    public Chapter(Subject subject, String name) {
        this.subject = subject;
        this.name = name;
    }
}
