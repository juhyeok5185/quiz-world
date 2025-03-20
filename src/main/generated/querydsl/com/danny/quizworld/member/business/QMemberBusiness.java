package com.danny.quizworld.member.business;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMemberBusiness is a Querydsl query type for MemberBusiness
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMemberBusiness extends EntityPathBase<MemberBusiness> {

    private static final long serialVersionUID = 528644996L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMemberBusiness memberBusiness = new QMemberBusiness("memberBusiness");

    public final com.danny.quizworld.common.entity.QBaseTimeEntity _super = new com.danny.quizworld.common.entity.QBaseTimeEntity(this);

    public final StringPath bankbookImage = createString("bankbookImage");

    public final StringPath businessImage = createString("businessImage");

    public final com.danny.quizworld.member.QMember member;

    public final NumberPath<Long> memberBusinessId = createNumber("memberBusinessId", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDtm = _super.modDtm;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> saveDtm = _super.saveDtm;

    //inherited
    public final BooleanPath useYn = _super.useYn;

    public QMemberBusiness(String variable) {
        this(MemberBusiness.class, forVariable(variable), INITS);
    }

    public QMemberBusiness(Path<? extends MemberBusiness> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMemberBusiness(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMemberBusiness(PathMetadata metadata, PathInits inits) {
        this(MemberBusiness.class, metadata, inits);
    }

    public QMemberBusiness(Class<? extends MemberBusiness> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new com.danny.quizworld.member.QMember(forProperty("member")) : null;
    }

}

