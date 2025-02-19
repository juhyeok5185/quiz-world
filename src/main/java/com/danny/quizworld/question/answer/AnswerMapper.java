package com.danny.quizworld.question.answer;

import com.danny.quizworld.question.Question;
import com.danny.quizworld.question.QuestionMapper;
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
    private final QuestionMapper questionMapper;

    public Answer toEntity(Question question ,AnswerRequest request){
        return Answer.builder()
                .question(question)
                .answerYn(request.getAnswerYn())
                .answerText(request.getAnswerText())
                .build();
    }

    public AnswerResponse toResponse(Answer answer) {
        return AnswerResponse.builder()
                .answerId(answer.getAnswerId())
                .question(questionMapper.toResponse(answer.getQuestion()))
                .answerYn(answer.getAnswerYn())
                .answerText(answer.getAnswerText())
                .build();
    }
}
