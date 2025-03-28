package com.danny.quizworld.member;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class MemberCommand {

    @Getter
    @Setter
    @NoArgsConstructor
    public static class updateNickname {
        private String nickname;


    }
}
