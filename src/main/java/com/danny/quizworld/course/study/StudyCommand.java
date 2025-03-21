package com.danny.quizworld.course.study;

import lombok.Builder;
import lombok.Getter;

public class StudyCommand {

    @Getter
    @Builder
    public static class save {
        private StudyType type;
        private String questionText;
        private String answerText;
        private String description;
    }

    @Getter
    @Builder
    public static class update {
        private StudyType type;
        private String questionText;
        private String answerText;
        private String description;
    }
}
