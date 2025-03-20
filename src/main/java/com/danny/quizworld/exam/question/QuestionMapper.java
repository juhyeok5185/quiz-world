package com.danny.quizworld.exam.question;

import com.danny.quizworld.course.chapter.Chapter;
import com.danny.quizworld.course.chapter.ChapterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class QuestionMapper {

    private final ChapterService chapterService;

    public Question toEntity(Chapter chapter, QuestionRequest request){
        return Question.builder()
                .subject(chapter.getSubject())
                .chapter(chapter)
                .questionText(request.getQuestionText())
                .description(request.getDescription())
                .build();
    }

    public QuestionResponse toResponse(Question question) {
        return QuestionResponse.builder()
                .questionId(question.getQuestionId())
                .chapter(chapterService.toResponse(question.getChapter()))
                .questionText(question.getQuestionText())
                .description(question.getDescription())
                .build();
    }
}
