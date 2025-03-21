package com.danny.quizworld.course.chapter;

import com.danny.quizworld.course.study.StudyType;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ChapterCommand {

    @Getter
    @Builder
    public static class save {
        @NotBlank(message = "챕터명은 필수입니다.")
        @Size(max = 1000 , message = "과목명은 1000자 이하로 입력해주세요")
        private String name;
    }

    @Getter
    @Builder
    public static class update {
        @NotBlank(message = "챕터명은 필수입니다.")
        @Size(max = 1000 , message = "과목명은 1000자 이하로 입력해주세요")
        private String name;
    }
}
