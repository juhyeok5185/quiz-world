package com.danny.quizworld.exam;

import com.danny.quizworld.exam.answer.AnswerRequest;
import com.danny.quizworld.exam.keyword.KeywordRequest;
import com.danny.quizworld.exam.question.QuestionRequest;
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
