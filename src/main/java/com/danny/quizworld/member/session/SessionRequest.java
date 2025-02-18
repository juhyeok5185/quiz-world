package com.danny.quizworld.member.session;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SessionRequest {
    @NotNull
    private String loginId;
    @NotNull
    private String password;
}
