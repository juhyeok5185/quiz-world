package com.danny.quizworld.course.chapter;

import com.danny.quizworld.course.subject.Subject;
import com.danny.quizworld.course.subject.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ChapterMapper {

    private final SubjectService subjectService;

    public Chapter toEntity(Subject subject, ChapterCommand.save request){
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
