package com.danny.quizworld.question.answer;

import com.danny.quizworld.question.Question;
import com.danny.quizworld.question.QuestionCommonResponse;
import com.danny.quizworld.question.QuestionResponse;
import com.danny.quizworld.question.QuestionType;
import com.danny.quizworld.question.passage.PassageResponse;
import com.danny.quizworld.subject.chapter.ChapterResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Builder
public class AnswerResponse {
    private Long answerId;
    private QuestionResponse question;
    private Boolean answerYn;
    private String answerText;
}
