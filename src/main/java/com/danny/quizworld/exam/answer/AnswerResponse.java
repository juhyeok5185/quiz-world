package com.danny.quizworld.exam.answer;

import com.danny.quizworld.exam.question.QuestionResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AnswerResponse {
    private Long answerId;
    private QuestionResponse question;
    private Boolean answerYn;
    private String answerText;
}
