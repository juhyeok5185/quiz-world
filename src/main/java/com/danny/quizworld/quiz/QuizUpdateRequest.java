package com.danny.quizworld.quiz;

import com.danny.quizworld.quiz.answer.AnswerRequest;
import com.danny.quizworld.quiz.keyword.KeywordRequest;
import com.danny.quizworld.quiz.question.QuestionRequest;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class QuizUpdateRequest {
    private QuestionRequest questionRequest;
    private List<AnswerRequest> answerRequest;
    private List<KeywordRequest> keywordRequest;
}
