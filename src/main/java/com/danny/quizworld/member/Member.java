package com.danny.quizworld.member;

import com.danny.quizworld.common.entity.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "t_member")
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "role")
    private MemberRole role; // 0: USER, 1: ADMIN

    @Column(name = "login_id")
    private String loginId;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "device_token")
    private String deviceToken;

    @Column(name = "like_count")
    private Integer likeCount;

    @Column(name = "subscribe_yn")
    private Boolean subscribeYn;

    @Column(name = "business_yn")
    private Boolean businessYn;

    @Builder
    public Member(MemberRole role, String loginId, String password, String name, String phone, String email, String deviceToken, Integer likeCount, Boolean subscribeYn, Boolean businessYn) {
        this.role = role;
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.deviceToken = deviceToken;
        this.likeCount = likeCount;
        this.subscribeYn = subscribeYn;
        this.businessYn = businessYn;
    }

    public void updateDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }
}
