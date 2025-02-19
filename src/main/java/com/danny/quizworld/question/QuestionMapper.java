package com.danny.quizworld.question;

import com.danny.quizworld.subject.Subject;
import com.danny.quizworld.subject.SubjectMapper;
import com.danny.quizworld.subject.chapter.Chapter;
import com.danny.quizworld.subject.chapter.ChapterMapper;
import com.danny.quizworld.subject.chapter.ChapterResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class QuestionMapper {

    private final ModelMapper modelMapper;
    private final ChapterMapper chapterMapper;

    public Question toEntity(Chapter chapter,QuestionShortTypeSaveRequest request){
        return Question.builder()
                .subject(chapter.getSubject())
                .chapter(chapter)
                .type(request.getType())
                .questionText(request.getQuestionText())
                .build();
    }

    public QuestionResponse toResponse(Question question) {
        return QuestionResponse.builder()
                .questionId(question.getQuestionId())
                .chapter(chapterMapper.toResponse(question.getChapter()))
                .type(question.getType())
                .questionText(question.getQuestionText())
                .build();
    }
}
