package com.danny.quizworld.member.subscribe;

import com.danny.quizworld.common.entity.BaseTimeEntity;
import com.danny.quizworld.member.Member;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "t_member_subscribe")
public class MemberSubscribe extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_subscribe_id")
    private Long memberSubscribeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "price")
    private Integer price;

    @Column(name = "pay_time")
    private LocalDateTime payTime;

    @Column(name = "subscribe_start_time")
    private LocalDateTime subscribeStartTime;

    @Column(name = "subscribe_end_time")
    private LocalDateTime subscribeEndTime;

    @Builder
    public MemberSubscribe(Member member, Integer price, LocalDateTime payTime, LocalDateTime subscribeStartTime, LocalDateTime subscribeEndTime) {
        this.member = member;
        this.price = price;
        this.payTime = payTime;
        this.subscribeStartTime = subscribeStartTime;
        this.subscribeEndTime = subscribeEndTime;
    }
}
