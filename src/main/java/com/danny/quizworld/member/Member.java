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

    @Column(name = "name")
    private String name; // 회원 이름

    @Column(name = "email")
    private String email; // 회원 이메일

    @Column(name = "device_token")
    private String deviceToken; // 회원 디바이스 토큰(앱)

    @Builder
    public Member(MemberRole role, String name, String email, String deviceToken) {
        this.role = role;
        this.name = name;
        this.email = email;
        this.deviceToken = deviceToken;
    }

    public void updateDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }
}
