package com.danny.quizworld.course.subject;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class SubjectCommand {

    @Getter
    @Builder
    public static class save {
        private String name;
        private String description;
        private Boolean publicYn;
        private Long price;
    }

    @Getter
    @Builder
    public static class update {
        private String name;
        private String description;
        private Boolean publicYn;
        private Long price;
    }
}
