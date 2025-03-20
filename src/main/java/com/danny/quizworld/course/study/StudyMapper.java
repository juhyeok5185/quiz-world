package com.danny.quizworld.course.study;

import com.danny.quizworld.course.chapter.Chapter;
import com.danny.quizworld.course.chapter.ChapterService;
import com.danny.quizworld.course.subject.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StudyMapper {

    private final ChapterService chapterService;
    private final SubjectService subjectService;

    public Study toEntity(Chapter chapter, StudyRequest request){
        return Study.builder()
                .chapter(chapter)
                .type(request.getType())
                .questionText(request.getQuestionText())
                .answerText(request.getAnswerText())
                .description(request.getDescription())
                .build();
    }

    public StudyResponse toResponse(Study study) {
        return StudyResponse.builder()
                .studyId(study.getStudyId())
                .chapter(chapterService.toResponse(study.getChapter()))
                .type(study.getType())
                .questionText(study.getQuestionText())
                .answerText(study.getAnswerText())
                .description(study.getDescription())
                .build();
    }
}
