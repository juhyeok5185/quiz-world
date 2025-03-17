package com.danny.quizworld.subject.chapter;

import com.danny.quizworld.subject.Subject;
import com.danny.quizworld.subject.SubjectMapper;
import com.danny.quizworld.subject.SubjectService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ChapterMapper {

    private final SubjectService subjectService;

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
                .subject(subjectService.toResponse(chapter.getSubject()))
                .build();
    }
}
