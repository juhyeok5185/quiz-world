package com.danny.quizworld.quiz.passage;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPassage is a Querydsl query type for Passage
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPassage extends EntityPathBase<Passage> {

    private static final long serialVersionUID = -717929147L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPassage passage = new QPassage("passage");

    public final com.danny.quizworld.common.entity.QBaseTimeEntity _super = new com.danny.quizworld.common.entity.QBaseTimeEntity(this);

    public final com.danny.quizworld.course.chapter.QChapter chapter;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDtm = _super.modDtm;

    public final NumberPath<Long> passageId = createNumber("passageId", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> saveDtm = _super.saveDtm;

    public final com.danny.quizworld.course.subject.QSubject subject;

    public final StringPath text = createString("text");

    //inherited
    public final BooleanPath useYn = _super.useYn;

    public QPassage(String variable) {
        this(Passage.class, forVariable(variable), INITS);
    }

    public QPassage(Path<? extends Passage> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPassage(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPassage(PathMetadata metadata, PathInits inits) {
        this(Passage.class, metadata, inits);
    }

    public QPassage(Class<? extends Passage> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.chapter = inits.isInitialized("chapter") ? new com.danny.quizworld.course.chapter.QChapter(forProperty("chapter"), inits.get("chapter")) : null;
        this.subject = inits.isInitialized("subject") ? new com.danny.quizworld.course.subject.QSubject(forProperty("subject"), inits.get("subject")) : null;
    }

}

