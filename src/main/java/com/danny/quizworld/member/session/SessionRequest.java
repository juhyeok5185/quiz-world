package com.danny.quizworld.member.session;

import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SessionRequest {
    @NotNull
    private String loginId;
    @NotNull
    private String password;
}
