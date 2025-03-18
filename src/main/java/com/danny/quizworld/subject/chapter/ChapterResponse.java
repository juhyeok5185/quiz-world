package com.danny.quizworld.subject.chapter;

import com.danny.quizworld.subject.SubjectResponse;
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
    private Long quizCount;
}
