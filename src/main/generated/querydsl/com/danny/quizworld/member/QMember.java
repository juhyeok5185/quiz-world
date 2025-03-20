package com.danny.quizworld.member;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = -25865154L;

    public static final QMember member = new QMember("member1");

    public final com.danny.quizworld.common.entity.QBaseTimeEntity _super = new com.danny.quizworld.common.entity.QBaseTimeEntity(this);

    public final BooleanPath businessYn = createBoolean("businessYn");

    public final StringPath deviceToken = createString("deviceToken");

    public final StringPath email = createString("email");

    public final NumberPath<Integer> likeCount = createNumber("likeCount", Integer.class);

    public final NumberPath<Long> memberId = createNumber("memberId", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDtm = _super.modDtm;

    public final StringPath name = createString("name");

    public final EnumPath<MemberRole> role = createEnum("role", MemberRole.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> saveDtm = _super.saveDtm;

    public final BooleanPath subscribeYn = createBoolean("subscribeYn");

    //inherited
    public final BooleanPath useYn = _super.useYn;

    public QMember(String variable) {
        super(Member.class, forVariable(variable));
    }

    public QMember(Path<? extends Member> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMember(PathMetadata metadata) {
        super(Member.class, metadata);
    }

}

