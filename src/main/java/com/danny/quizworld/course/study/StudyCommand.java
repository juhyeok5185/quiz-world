package com.danny.quizworld.course.study;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class StudyCommand {

    @Getter
    @Setter
    @NoArgsConstructor
    public static class save {
        private StudyType type;
//        @NotBlank(message = "과목명은 필수입니다.")
//        @Size(max = 1000 , message = "과목명은 1000자 이하로 입력해주세요")
        private String questionText;
//        @NotBlank(message = "과목명은 필수입니다.")
//        @Size(max = 1000 , message = "과목명은 1000자 이하로 입력해주세요")
        private String answerText;
        private String description;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class update {
        private StudyType type;
        @NotBlank(message = "과목명은 필수입니다.")
        @Size(max = 1000 , message = "과목명은 1000자 이하로 입력해주세요")
        private String questionText;
        @NotBlank(message = "과목명은 필수입니다.")
        @Size(max = 1000 , message = "과목명은 1000자 이하로 입력해주세요")
        private String answerText;
        private String description;
    }
}
