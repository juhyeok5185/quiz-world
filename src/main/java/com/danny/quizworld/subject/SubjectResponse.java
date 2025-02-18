package com.danny.quizworld.subject;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SubjectResponse {
    private String subjectId;
    private String name;
}
