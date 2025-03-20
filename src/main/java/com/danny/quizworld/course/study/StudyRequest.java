package com.danny.quizworld.course.study;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudyRequest {
    private StudyType type;
    private String questionText;
    private String answerText;
    private String description;
}
