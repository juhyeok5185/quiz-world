package com.danny.quizworld.course.subject.category;

import com.danny.quizworld.common.entity.BaseTimeEntity;
import com.danny.quizworld.course.subject.SubjectCommand;
import com.danny.quizworld.member.Member;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "t_category")
public class Category extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "name")
    private String name;

    @Builder
    public Category(Long categoryId, String name) {
        this.name = name;
    }
}
