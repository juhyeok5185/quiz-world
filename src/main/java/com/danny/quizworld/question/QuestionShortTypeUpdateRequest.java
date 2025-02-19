package com.danny.quizworld.question;

import com.danny.quizworld.question.answer.AnswerRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionShortTypeUpdateRequest {
    private QuestionType type;
    private String questionText;
    private String answerText;
}
