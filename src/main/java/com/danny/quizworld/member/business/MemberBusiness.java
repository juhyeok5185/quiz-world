package com.danny.quizworld.member.business;

import com.danny.quizworld.common.entity.BaseTimeEntity;
import com.danny.quizworld.member.Member;
import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "t_member_business")
public class MemberBusiness extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_business_id")
    private Long memberBusinessId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "business_image")
    private String businessImage;

    @Column(name = "bankbook_image")
    private String bankbookImage;

    @Builder
    public MemberBusiness(Member member, String businessImage, String bankbookImage) {
        this.member = member;
        this.businessImage = businessImage;
        this.bankbookImage = bankbookImage;
    }
}
