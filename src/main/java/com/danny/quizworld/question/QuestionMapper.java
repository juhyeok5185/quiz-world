package com.danny.quizworld.question;

import com.danny.quizworld.subject.Subject;
import com.danny.quizworld.subject.SubjectMapper;
import com.danny.quizworld.subject.chapter.Chapter;
import com.danny.quizworld.subject.chapter.ChapterResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class QuestionMapper {

    private final ModelMapper modelMapper;

    public Chapter toEntity(Subject subject, String name){
        return null;
    }

    public ChapterResponse toResponse(Chapter chapter) {
        return null;
    }
}
