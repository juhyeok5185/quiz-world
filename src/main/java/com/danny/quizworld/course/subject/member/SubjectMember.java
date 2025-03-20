package com.danny.quizworld.course.subject.member;

import com.danny.quizworld.course.subject.Subject;
import com.danny.quizworld.member.Member;
import com.danny.quizworld.common.entity.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "t_subject_member")
public class SubjectMember extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_member_id")
    private Long subjectMemberId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @Builder
    public SubjectMember(Member member, Subject subject) {
        this.member = member;
        this.subject = subject;
    }
}
