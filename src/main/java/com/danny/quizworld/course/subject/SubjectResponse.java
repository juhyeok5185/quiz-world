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
    private Boolean publicYn;
    private Long price;
    private Integer likeCount;
    private Integer downloadCount;
    private Long quizCount;
}
