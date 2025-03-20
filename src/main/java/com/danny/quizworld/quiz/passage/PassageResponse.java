package com.danny.quizworld.quiz.passage;

import com.danny.quizworld.course.chapter.ChapterResponse;
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
