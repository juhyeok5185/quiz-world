package com.danny.quizworld.member;

import com.danny.quizworld.common.entity.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "t_member")
public class Member extends BaseTimeEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long memberId; // 회원 일련번호

    @Column(name = "role")
    private MemberRole role; // 역할

    @Column(name = "login_id")
    private String loginId; // 회원 로그인 아이디

    @Column(name = "password")
    private String password; // 회원 비밀번호

    @Column(name = "name")
    private String name; // 회원 이름

    @Column(name = "phone")
    private String phone; // 회원 전화번호

    @Column(name = "email")
    private String email; // 회원 이메일

    @Column(name = "device_token")
    private String deviceToken; // 회원 디바이스 토큰(앱)

    @Builder
    public Member(MemberRole role, String loginId, String password, String name, String phone, String email, String deviceToken) {
        this.role = role;
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.deviceToken = deviceToken;
    }
}
