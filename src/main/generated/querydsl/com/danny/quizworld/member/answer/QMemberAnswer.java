package com.danny.quizworld.member.answer;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMemberAnswer is a Querydsl query type for MemberAnswer
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMemberAnswer extends EntityPathBase<MemberAnswer> {

    private static final long serialVersionUID = 1881495620L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMemberAnswer memberAnswer = new QMemberAnswer("memberAnswer");

    public final com.danny.quizworld.exam.answer.QAnswer answer;

    public final com.danny.quizworld.member.QMember member;

    public final NumberPath<Long> memberAnswerId = createNumber("memberAnswerId", Long.class);

    public QMemberAnswer(String variable) {
        this(MemberAnswer.class, forVariable(variable), INITS);
    }

    public QMemberAnswer(Path<? extends MemberAnswer> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMemberAnswer(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMemberAnswer(PathMetadata metadata, PathInits inits) {
        this(MemberAnswer.class, metadata, inits);
    }

    public QMemberAnswer(Class<? extends MemberAnswer> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.answer = inits.isInitialized("answer") ? new com.danny.quizworld.exam.answer.QAnswer(forProperty("answer"), inits.get("answer")) : null;
        this.member = inits.isInitialized("member") ? new com.danny.quizworld.member.QMember(forProperty("member")) : null;
    }

}

