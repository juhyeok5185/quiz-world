package com.danny.quizworld.course.subject;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SubjectCommand {

    @Getter
    @Setter
    @NoArgsConstructor
    public static class save {
        @NotBlank(message = "과목명은 필수입니다.")
        @Size(max = 1000 , message = "과목명은 1000자 이하로 입력해주세요")
        private String name;

        @Size(max = 2000, message = "설명은 2000자 이하로 입력해주세요.")
        private String description;

        @NotNull(message = "공개 여부는 필수입니다.")
        private Boolean publicYn;
        private Long price;

        @NotNull(message = "카테고리를 선택해주세요")
        private Integer categoryId;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class update {
        @NotBlank(message = "과목명은 필수입니다.")
        @Size(max = 1000 , message = "과목명은 1000자 이하로 입력해주세요")
        private String name;

        @Size(max = 2000, message = "설명은 2000자 이하로 입력해주세요.")
        private String description;

        @NotNull(message = "공개 여부는 필수입니다.")
        private Boolean publicYn;
        private Long price;

        @NotNull(message = "카테고리를 선택해주세요")
        private Integer categoryId;
    }
}
