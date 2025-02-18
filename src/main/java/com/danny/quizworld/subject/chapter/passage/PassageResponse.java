package com.danny.quizworld.subject.chapter.passage;

import com.danny.quizworld.subject.SubjectResponse;
import com.danny.quizworld.subject.chapter.ChapterResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PassageResponse {
    private Long passageId;
    private String text;
    private ChapterResponse chapter;
}
