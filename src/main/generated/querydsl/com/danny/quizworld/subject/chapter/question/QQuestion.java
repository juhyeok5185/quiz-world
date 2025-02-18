package com.danny.quizworld.subject.chapter.question;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QQuestion is a Querydsl query type for Question
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QQuestion extends EntityPathBase<Question> {

    private static final long serialVersionUID = 173739803L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QQuestion question = new QQuestion("question");

    public final com.danny.quizworld.common.entity.QBaseTimeEntity _super = new com.danny.quizworld.common.entity.QBaseTimeEntity(this);

    public final com.danny.quizworld.subject.chapter.QChapter chapter;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDtm = _super.modDtm;

    public final com.danny.quizworld.subject.chapter.passage.QPassage passage;

    public final NumberPath<Long> passageId = createNumber("passageId", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> saveDtm = _super.saveDtm;

    public final com.danny.quizworld.subject.QSubject subject;

    public final StringPath text = createString("text");

    public final StringPath type = createString("type");

    //inherited
    public final BooleanPath useYn = _super.useYn;

    public QQuestion(String variable) {
        this(Question.class, forVariable(variable), INITS);
    }

    public QQuestion(Path<? extends Question> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QQuestion(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QQuestion(PathMetadata metadata, PathInits inits) {
        this(Question.class, metadata, inits);
    }

    public QQuestion(Class<? extends Question> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.chapter = inits.isInitialized("chapter") ? new com.danny.quizworld.subject.chapter.QChapter(forProperty("chapter"), inits.get("chapter")) : null;
        this.passage = inits.isInitialized("passage") ? new com.danny.quizworld.subject.chapter.passage.QPassage(forProperty("passage"), inits.get("passage")) : null;
        this.subject = inits.isInitialized("subject") ? new com.danny.quizworld.subject.QSubject(forProperty("subject"), inits.get("subject")) : null;
    }

}

