package com.danny.quizworld.member.score;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMemberScoreLog is a Querydsl query type for MemberScoreLog
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMemberScoreLog extends EntityPathBase<MemberScoreLog> {

    private static final long serialVersionUID = -371944052L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMemberScoreLog memberScoreLog = new QMemberScoreLog("memberScoreLog");

    public final com.danny.quizworld.common.entity.QBaseTimeEntity _super = new com.danny.quizworld.common.entity.QBaseTimeEntity(this);

    public final com.danny.quizworld.member.QMember member;

    public final NumberPath<Long> memberScoreLogId = createNumber("memberScoreLogId", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDtm = _super.modDtm;

    public final NumberPath<Integer> month = createNumber("month", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> saveDtm = _super.saveDtm;

    public final NumberPath<Integer> score = createNumber("score", Integer.class);

    //inherited
    public final BooleanPath useYn = _super.useYn;

    public final NumberPath<Integer> year = createNumber("year", Integer.class);

    public QMemberScoreLog(String variable) {
        this(MemberScoreLog.class, forVariable(variable), INITS);
    }

    public QMemberScoreLog(Path<? extends MemberScoreLog> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMemberScoreLog(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMemberScoreLog(PathMetadata metadata, PathInits inits) {
        this(MemberScoreLog.class, metadata, inits);
    }

    public QMemberScoreLog(Class<? extends MemberScoreLog> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new com.danny.quizworld.member.QMember(forProperty("member")) : null;
    }

}

