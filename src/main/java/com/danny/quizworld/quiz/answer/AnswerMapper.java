package com.danny.quizworld.quiz.answer;

import com.danny.quizworld.quiz.question.Question;
import com.danny.quizworld.quiz.question.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AnswerMapper {

    private final QuestionService questionService;

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
                .question(questionService.toResponse(answer.getQuestion()))
                .answerYn(answer.getAnswerYn())
                .answerText(answer.getAnswerText())
                .build();
    }
}
