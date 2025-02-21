package com.danny.quizworld.subject;

import com.danny.quizworld.member.Member;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SubjectMapper {

    private final ModelMapper modelMapper;

    public Subject toEntity(Member member, SubjectRequest request){
        return Subject.builder()
                .member(member)
                .name(request.getName())
                .build();
    }

    public SubjectResponse toResponse(Subject subject) {
        return SubjectResponse.builder()
                .subjectId(subject.getSubjectId())
                .name(subject.getName())
                .build();
    }
}
