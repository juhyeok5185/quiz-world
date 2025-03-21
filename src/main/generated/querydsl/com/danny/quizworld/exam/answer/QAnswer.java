package com.danny.quizworld.exam.answer;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAnswer is a Querydsl query type for Answer
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAnswer extends EntityPathBase<Answer> {

    private static final long serialVersionUID = -1401251121L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAnswer answer = new QAnswer("answer");

    public final com.danny.quizworld.common.entity.QBaseTimeEntity _super = new com.danny.quizworld.common.entity.QBaseTimeEntity(this);

    public final NumberPath<Long> answerId = createNumber("answerId", Long.class);

    public final StringPath answerText = createString("answerText");

    public final BooleanPath answerYn = createBoolean("answerYn");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDtm = _super.modDtm;

    public final com.danny.quizworld.exam.question.QQuestion question;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> saveDtm = _super.saveDtm;

    //inherited
    public final BooleanPath useYn = _super.useYn;

    public QAnswer(String variable) {
        this(Answer.class, forVariable(variable), INITS);
    }

    public QAnswer(Path<? extends Answer> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAnswer(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAnswer(PathMetadata metadata, PathInits inits) {
        this(Answer.class, metadata, inits);
    }

    public QAnswer(Class<? extends Answer> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.question = inits.isInitialized("question") ? new com.danny.quizworld.exam.question.QQuestion(forProperty("question"), inits.get("question")) : null;
    }

}

