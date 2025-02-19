package com.danny.quizworld.question.answer;

import com.danny.quizworld.question.QuestionType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerRequest {
    private String answerText;
    private Boolean answerYn;
}
