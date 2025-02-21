package com.danny.quizworld.question.file;

import com.danny.quizworld.common.entity.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "t_question_file")
public class QuestionFile extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_file_id")
    private Long QuestionFileId;

    @Column(name = "target")
    private QuestionFileTarget target;

    @Column(name = "target_id")
    private Long targetId;

    @Column(name = "org_name")
    private String orgName;

    @Column(name = "save_name")
    private String saveName;
}
