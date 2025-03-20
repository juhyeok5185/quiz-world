package com.danny.quizworld.course.subject;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SubjectResponse {
    private Long subjectId;
    private String name;
    private String description;
    private Long quizCount;
}
