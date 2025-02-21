package com.danny.quizworld.question;

import com.danny.quizworld.question.answer.AnswerRequest;
import com.danny.quizworld.question.keyword.KeywordRequest;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class QuestionSaveRequest {
    private QuestionRequest questionRequest;
    private List<AnswerRequest> answerRequest;
    private List<KeywordRequest> keywordRequest;
}
