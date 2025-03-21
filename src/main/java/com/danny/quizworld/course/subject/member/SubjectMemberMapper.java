package com.danny.quizworld.course.subject.member;

import com.danny.quizworld.course.subject.Subject;
import com.danny.quizworld.course.subject.SubjectCommand;
import com.danny.quizworld.course.subject.SubjectResponse;
import com.danny.quizworld.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SubjectMemberMapper {

    public SubjectMember toEntity(Subject subject , Member member) {
        return SubjectMember.builder()
                .subject(subject)
                .member(member)
                .build();
    }


}
