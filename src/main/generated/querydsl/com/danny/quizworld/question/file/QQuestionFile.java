package com.danny.quizworld.question.file;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QQuestionFile is a Querydsl query type for QuestionFile
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QQuestionFile extends EntityPathBase<QuestionFile> {

    private static final long serialVersionUID = 260112412L;

    public static final QQuestionFile questionFile = new QQuestionFile("questionFile");

    public final com.danny.quizworld.common.entity.QBaseTimeEntity _super = new com.danny.quizworld.common.entity.QBaseTimeEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDtm = _super.modDtm;

    public final StringPath orgName = createString("orgName");

    public final NumberPath<Long> QuestionFileId = createNumber("QuestionFileId", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> saveDtm = _super.saveDtm;

    public final StringPath saveName = createString("saveName");

    public final EnumPath<QuestionFileTarget> target = createEnum("target", QuestionFileTarget.class);

    public final NumberPath<Long> targetId = createNumber("targetId", Long.class);

    //inherited
    public final BooleanPath useYn = _super.useYn;

    public QQuestionFile(String variable) {
        super(QuestionFile.class, forVariable(variable));
    }

    public QQuestionFile(Path<? extends QuestionFile> path) {
        super(path.getType(), path.getMetadata());
    }

    public QQuestionFile(PathMetadata metadata) {
        super(QuestionFile.class, metadata);
    }

}

