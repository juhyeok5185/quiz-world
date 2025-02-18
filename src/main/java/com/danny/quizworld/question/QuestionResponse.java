package com.danny.quizworld.question;

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

@Getter
@Setter
@Builder
public class QuestionResponse {
    private Long quizId; // 회원 일련번호
    private ChapterResponse chapter;
    private PassageResponse passage;
    private QuestionType type;
    private String text;
}
