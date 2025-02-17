package com.danny.quizworld.subject.chapter;

import com.danny.quizworld.common.entity.BaseTimeEntity;
import com.danny.quizworld.member.Member;
import com.danny.quizworld.subject.Subject;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
}
