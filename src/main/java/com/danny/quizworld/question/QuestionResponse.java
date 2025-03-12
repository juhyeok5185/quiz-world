package com.danny.quizworld.question;

import com.danny.quizworld.question.answer.AnswerResponse;
import com.danny.quizworld.question.passage.Passage;
import com.danny.quizworld.question.passage.PassageResponse;
import com.danny.quizworld.subject.Subject;
import com.danny.quizworld.subject.SubjectResponse;
import com.danny.quizworld.subject.chapter.Chapter;
import com.danny.quizworld.subject.chapter.ChapterResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Builder
public class QuestionResponse {
    private Long questionId; // 회원 일련번호
    private ChapterResponse chapter;
    private PassageResponse passage;
    private QuestionType type;
    private String questionText;
    private String description;
    private List<AnswerResponse> answers;
}
