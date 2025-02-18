package com.danny.quizworld.member;

import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberSaveRequest {
    @NotNull(message = "로그인 ID는 필수입니다.")
    private String loginId; // 회원 로그인 아이디

    @NotNull(message = "비밀번호는 필수입니다.")
    private String password; // 회원 비밀번호

    @NotNull(message = "이름은 필수입니다.")
    private String name; // 회원 이름

    @NotNull(message = "휴대전화는 필수입니다.")
    private String phone; // 회원 이름

    @NotNull(message = "email 필수입니다.")
    private String email; // 회원 이름

    @NotNull
    private MemberRole role;
}
