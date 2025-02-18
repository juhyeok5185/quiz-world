package com.danny.quizworld.question.answer;

import com.danny.quizworld.subject.Subject;
import com.danny.quizworld.subject.chapter.Chapter;
import com.danny.quizworld.subject.chapter.ChapterResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AnswerMapper {

    private final ModelMapper modelMapper;

    public Answer toEntity(){
        return null;
    }

    public AnswerResponse toResponse(Answer answer) {
        return null;
    }
}
