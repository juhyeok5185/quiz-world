package com.danny.quizworld.course.subject.member;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSubjectMember is a Querydsl query type for SubjectMember
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSubjectMember extends EntityPathBase<SubjectMember> {

    private static final long serialVersionUID = 243334807L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSubjectMember subjectMember = new QSubjectMember("subjectMember");

    public final com.danny.quizworld.common.entity.QBaseTimeEntity _super = new com.danny.quizworld.common.entity.QBaseTimeEntity(this);

    public final com.danny.quizworld.member.QMember member;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDtm = _super.modDtm;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> saveDtm = _super.saveDtm;

    public final com.danny.quizworld.course.subject.QSubject subject;

    public final NumberPath<Long> subjectMemberId = createNumber("subjectMemberId", Long.class);

    //inherited
    public final BooleanPath useYn = _super.useYn;

    public QSubjectMember(String variable) {
        this(SubjectMember.class, forVariable(variable), INITS);
    }

    public QSubjectMember(Path<? extends SubjectMember> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSubjectMember(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSubjectMember(PathMetadata metadata, PathInits inits) {
        this(SubjectMember.class, metadata, inits);
    }

    public QSubjectMember(Class<? extends SubjectMember> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new com.danny.quizworld.member.QMember(forProperty("member")) : null;
        this.subject = inits.isInitialized("subject") ? new com.danny.quizworld.course.subject.QSubject(forProperty("subject"), inits.get("subject")) : null;
    }

}

