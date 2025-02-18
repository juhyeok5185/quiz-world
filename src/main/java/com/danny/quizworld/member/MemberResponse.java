package com.danny.quizworld.member;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MemberResponse {
    private Long memberId; // 회원 일련번호
    private String loginId; // 회원 로그인 아이디
    private String name; // 회원 이름
    private String phone; // 회원 전화번호
    private String email; // 회원 이메일
}
