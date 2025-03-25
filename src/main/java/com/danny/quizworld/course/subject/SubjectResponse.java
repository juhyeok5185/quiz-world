package com.danny.quizworld.course.subject;

import com.danny.quizworld.course.subject.category.CategoryResponse;
import com.danny.quizworld.member.MemberResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SubjectResponse {
    private Long subjectId;
    private String name;
    private String description;
    private Boolean publicYn;
    private Long price;
    private Integer likeCount;
    private Integer downloadCount;
    private Long studyCount;
    private MemberResponse member;
    private Boolean createYn;
    private CategoryResponse category;
}
