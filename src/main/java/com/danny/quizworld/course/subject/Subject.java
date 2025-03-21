package com.danny.quizworld.course.subject;

import com.danny.quizworld.member.Member;
import com.danny.quizworld.common.entity.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "t_subject")
public class Subject extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_id")
    private Long subjectId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "like_count")
    private Integer likeCount;

    @Column(name = "download_count")
    private Integer downloadCount;

    @Column(name = "download_id")
    private Long downloadId;

    @Column(name = "public_yn")
    private Boolean publicYn;

    @Column(name = "price")
    private Long price;


    @Builder
    public Subject(Member member, String name, String description, Integer likeCount, Integer downloadCount, Boolean downloadYn, Long downloadId, Boolean publicYn, Long price) {
        this.member = member;
        this.name = name;
        this.description = description;
        this.likeCount = likeCount;
        this.downloadCount = downloadCount;
        this.downloadId = downloadId;
        this.publicYn = publicYn;
        this.price = price;
    }

    public void update(SubjectCommand.update request) {
        this.name = request.getName();
        this.description = request.getDescription();
        this.publicYn = request.getPublicYn();
        this.price = request.getPrice();
    }
}
