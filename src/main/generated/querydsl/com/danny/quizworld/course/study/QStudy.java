package com.danny.quizworld.course.study;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStudy is a Querydsl query type for Study
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStudy extends EntityPathBase<Study> {

    private static final long serialVersionUID = 1931210305L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QStudy study = new QStudy("study");

    public final com.danny.quizworld.common.entity.QBaseTimeEntity _super = new com.danny.quizworld.common.entity.QBaseTimeEntity(this);

    public final StringPath answerText = createString("answerText");

    public final com.danny.quizworld.course.chapter.QChapter chapter;

    public final StringPath description = createString("description");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDtm = _super.modDtm;

    public final StringPath questionText = createString("questionText");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> saveDtm = _super.saveDtm;

    public final NumberPath<Long> studyId = createNumber("studyId", Long.class);

    public final com.danny.quizworld.course.subject.QSubject subject;

    public final EnumPath<StudyType> type = createEnum("type", StudyType.class);

    //inherited
    public final BooleanPath useYn = _super.useYn;

    public QStudy(String variable) {
        this(Study.class, forVariable(variable), INITS);
    }

    public QStudy(Path<? extends Study> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QStudy(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QStudy(PathMetadata metadata, PathInits inits) {
        this(Study.class, metadata, inits);
    }

    public QStudy(Class<? extends Study> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.chapter = inits.isInitialized("chapter") ? new com.danny.quizworld.course.chapter.QChapter(forProperty("chapter"), inits.get("chapter")) : null;
        this.subject = inits.isInitialized("subject") ? new com.danny.quizworld.course.subject.QSubject(forProperty("subject"), inits.get("subject")) : null;
    }

}

