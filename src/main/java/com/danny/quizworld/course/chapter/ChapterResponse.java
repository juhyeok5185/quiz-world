package com.danny.quizworld.course.chapter;

import com.danny.quizworld.course.subject.SubjectResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ChapterResponse {
    private Long chapterId;
    private String name;
    private SubjectResponse subject;
    private Long studyCount;
}
