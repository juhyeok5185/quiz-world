package com.danny.quizworld.question;

import com.danny.quizworld.question.answer.AnswerResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class QuestionCommonResponse {
    private QuestionResponse question;
    private List<AnswerResponse> answer;


    public QuestionCommonResponse(QuestionResponse question, List<AnswerResponse> answer) {
        this.question = question;
        this.answer = answer;
    }
}
