package com.danny.quizworld.question;

import com.danny.quizworld.question.answer.AnswerRequest;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class QuestionMultipleTypeSaveRequest {
    private QuestionType type;
    private String questionText;
    private List<AnswerRequest> answerRequest;
}
