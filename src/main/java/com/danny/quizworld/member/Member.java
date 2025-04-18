package com.danny.quizworld.member;

import com.danny.quizworld.common.entity.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    @Column(name = "name")
    private String name;

    @Column(name = "auth_id")
    private String authId;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "device_token")
    private String deviceToken;

    @Column(name = "like_count")
    private Integer likeCount;

    @Column(name = "score")
    private Integer score;

    @Column(name = "login_token")
    private String loginToken;

    @Column(name = "login_token_expiry")
    private LocalDateTime loginTokenExpiry;

    @Column(name = "subscribe_yn")
    private Boolean subscribeYn;

    @Column(name = "business_yn")
    private Boolean businessYn;

    @Builder
    public Member(MemberRole role,  String name, String authId,String nickname, String deviceToken, Integer likeCount, Integer score,String loginToken , LocalDateTime loginTokenExpiry, Boolean subscribeYn, Boolean businessYn) {
        this.role = role;
        this.name = name;
        this.authId = authId;
        this.nickname = nickname;
        this.deviceToken = deviceToken;
        this.likeCount = likeCount;
        this.score = score;
        this.loginToken = loginToken;
        this.loginTokenExpiry = loginTokenExpiry;
        this.subscribeYn = subscribeYn;
        this.businessYn = businessYn;
    }

    public void addScore() {
        this.score += 10;
    }

    public void initScore() {
        this.score = 0;
    }

    public void updateNickname(String nickname) {
        this.nickname = nickname;
    }

    public void updateLoginToken(String loginToken, LocalDateTime loginTokenExpiry) {
        this.loginToken = loginToken;
        this.loginTokenExpiry = loginTokenExpiry;
    }

    public void updateDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }
}
