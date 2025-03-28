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
    private String nickname;
    private Integer likeCount;
    private Boolean subscribeYn;
    private Integer score;
    private Boolean businessYn;
}
