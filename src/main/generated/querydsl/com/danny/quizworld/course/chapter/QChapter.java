package com.danny.quizworld.course.chapter;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QChapter is a Querydsl query type for Chapter
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QChapter extends EntityPathBase<Chapter> {

    private static final long serialVersionUID = -506900983L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QChapter chapter = new QChapter("chapter");

    public final com.danny.quizworld.common.entity.QBaseTimeEntity _super = new com.danny.quizworld.common.entity.QBaseTimeEntity(this);

    public final NumberPath<Long> chapterId = createNumber("chapterId", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDtm = _super.modDtm;

    public final StringPath name = createString("name");

    public final BooleanPath publicYn = createBoolean("publicYn");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> saveDtm = _super.saveDtm;

    public final com.danny.quizworld.course.subject.QSubject subject;

    //inherited
    public final BooleanPath useYn = _super.useYn;

    public QChapter(String variable) {
        this(Chapter.class, forVariable(variable), INITS);
    }

    public QChapter(Path<? extends Chapter> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QChapter(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QChapter(PathMetadata metadata, PathInits inits) {
        this(Chapter.class, metadata, inits);
    }

    public QChapter(Class<? extends Chapter> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.subject = inits.isInitialized("subject") ? new com.danny.quizworld.course.subject.QSubject(forProperty("subject"), inits.get("subject")) : null;
    }

}

