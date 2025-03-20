package com.danny.quizworld.course.subject;

import com.danny.quizworld.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SubjectMapper {

    public Subject toEntity(Member member, SubjectRequest request){
        return Subject.builder()
                .member(member)
                .name(request.getName())
                .description(request.getDescription())
                .build();
    }

    public SubjectResponse toResponse(Subject subject) {
        return SubjectResponse.builder()
                .subjectId(subject.getSubjectId())
                .name(subject.getName())
                .description(subject.getDescription())
                .build();
    }
}
