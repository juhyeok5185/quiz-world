package com.danny.quizworld.member;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class MemberResponse {
    private String name;
    private String authId;
    private String nickname;
    private Integer likeCount;
    private Boolean subscribeYn;
    private Integer score;
    private Boolean businessYn;
    private String loginToken;
    private LocalDateTime loginTokenExpiry;
}
