package com.danny.quizworld.subject;

import com.danny.quizworld.member.Member;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SubjectMapper {

    private final ModelMapper modelMapper;

    public Subject toEntity(Member member, String name){
        return Subject.builder()
                .member(member)
                .name(name)
                .build();
    }

    public SubjectResponse toResponse(Subject subject) {
        return modelMapper.map(subject, SubjectResponse.class);
    }
}
