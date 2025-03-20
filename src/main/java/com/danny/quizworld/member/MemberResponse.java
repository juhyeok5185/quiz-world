package com.danny.quizworld.member;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MemberResponse {
    private String name;
    private String email;
    private Integer likeCount;
    private Boolean subscribeYn;
    private Boolean businessYn;
}
