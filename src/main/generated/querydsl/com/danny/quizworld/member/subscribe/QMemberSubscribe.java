package com.danny.quizworld.member.subscribe;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMemberSubscribe is a Querydsl query type for MemberSubscribe
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMemberSubscribe extends EntityPathBase<MemberSubscribe> {

    private static final long serialVersionUID = 706145032L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMemberSubscribe memberSubscribe = new QMemberSubscribe("memberSubscribe");

    public final com.danny.quizworld.common.entity.QBaseTimeEntity _super = new com.danny.quizworld.common.entity.QBaseTimeEntity(this);

    public final com.danny.quizworld.member.QMember member;

    public final NumberPath<Long> memberSubscribeId = createNumber("memberSubscribeId", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDtm = _super.modDtm;

    public final DateTimePath<java.time.LocalDateTime> payTime = createDateTime("payTime", java.time.LocalDateTime.class);

    public final NumberPath<Integer> price = createNumber("price", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> saveDtm = _super.saveDtm;

    public final DateTimePath<java.time.LocalDateTime> subscribeEndTime = createDateTime("subscribeEndTime", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> subscribeStartTime = createDateTime("subscribeStartTime", java.time.LocalDateTime.class);

    //inherited
    public final BooleanPath useYn = _super.useYn;

    public QMemberSubscribe(String variable) {
        this(MemberSubscribe.class, forVariable(variable), INITS);
    }

    public QMemberSubscribe(Path<? extends MemberSubscribe> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMemberSubscribe(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMemberSubscribe(PathMetadata metadata, PathInits inits) {
        this(MemberSubscribe.class, metadata, inits);
    }

    public QMemberSubscribe(Class<? extends MemberSubscribe> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new com.danny.quizworld.member.QMember(forProperty("member")) : null;
    }

}

