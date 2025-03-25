package com.danny.quizworld.course.subject.category;

import com.danny.quizworld.member.MemberResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CategoryResponse {
    private Integer categoryId;
    private String name;
}
