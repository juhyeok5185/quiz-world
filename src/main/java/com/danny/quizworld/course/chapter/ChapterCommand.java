package com.danny.quizworld.course.chapter;

import com.danny.quizworld.course.study.StudyType;
import lombok.Builder;
import lombok.Getter;

public class ChapterCommand {

    @Getter
    @Builder
    public static class save {
        private String name;
    }

    @Getter
    @Builder
    public static class update {
        private String name;
    }
}
