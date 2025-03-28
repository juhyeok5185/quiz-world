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

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "device_token")
    private String deviceToken;

    @Column(name = "like_count")
    private Integer likeCount;

    @Column(name = "score")
    private Integer score;

    @Column(name = "subscribe_yn")
    private Boolean subscribeYn;

    @Column(name = "business_yn")
    private Boolean businessYn;

    @Builder
    public Member(MemberRole role,  String name, String email,String nickname, String deviceToken, Integer likeCount, Integer score, Boolean subscribeYn, Boolean businessYn) {
        this.role = role;
        this.name = name;
        this.email = email;
        this.nickname = nickname;
        this.deviceToken = deviceToken;
        this.likeCount = likeCount;
        this.score = score;
        this.subscribeYn = subscribeYn;
        this.businessYn = businessYn;
    }

    public void updateDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    public void addScore() {
        this.score += 10;
    }

    public void initScore() {
        this.score = 0;
    }
}
