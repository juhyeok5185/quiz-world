package com.danny.quizworld.quiz;

import com.danny.quizworld.quiz.answer.AnswerResponse;
import com.danny.quizworld.quiz.question.QuestionResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class QuizCommonResponse {
    private QuestionResponse question;
    private List<AnswerResponse> answer;


    public QuizCommonResponse(QuestionResponse question, List<AnswerResponse> answer) {
        this.question = question;
        this.answer = answer;
    }
}
