package com.danny.quizworld.course.study;

import com.danny.quizworld.course.chapter.Chapter;
import com.danny.quizworld.course.chapter.ChapterResponse;
import com.danny.quizworld.course.subject.Subject;
import com.danny.quizworld.course.subject.SubjectResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Builder
public class StudyResponse {
    private Long studyId;
    private ChapterResponse chapter;
    private String questionText;
    private String answerText;
    private String description;
}
