package com.danny.quizworld.subject.chapter;

import com.danny.quizworld.subject.Subject;
import com.danny.quizworld.subject.SubjectMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ChapterMapper {

    private final ModelMapper modelMapper;
    private final SubjectMapper subjectMapper;

    public Chapter toEntity(Subject subject, ChapterRequest request){
        return Chapter.builder()
                .subject(subject)
                .name(request.getName())
                .build();
    }

    public ChapterResponse toResponse(Chapter chapter) {
        return ChapterResponse.builder()
                .chapterId(chapter.getChapterId())
                .name(chapter.getName())
                .subject(subjectMapper.toResponse(chapter.getSubject()))
                .build();
    }
}
