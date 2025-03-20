package com.danny.quizworld.exam;

import com.danny.quizworld.exam.answer.AnswerResponse;
import com.danny.quizworld.exam.question.QuestionResponse;
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
