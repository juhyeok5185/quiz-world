package com.danny.quizworld.quiz.question;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionRequest {
    private QuestionType type;
    private String questionText;
    private String description;
}
