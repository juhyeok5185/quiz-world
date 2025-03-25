package com.danny.quizworld.course.subject.category;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QCategory is a Querydsl query type for Category
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCategory extends EntityPathBase<Category> {

    private static final long serialVersionUID = 1500883465L;

    public static final QCategory category = new QCategory("category");

    public final com.danny.quizworld.common.entity.QBaseTimeEntity _super = new com.danny.quizworld.common.entity.QBaseTimeEntity(this);

    public final NumberPath<Integer> categoryId = createNumber("categoryId", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDtm = _super.modDtm;

    public final StringPath name = createString("name");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> saveDtm = _super.saveDtm;

    //inherited
    public final BooleanPath useYn = _super.useYn;

    public QCategory(String variable) {
        super(Category.class, forVariable(variable));
    }

    public QCategory(Path<? extends Category> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCategory(PathMetadata metadata) {
        super(Category.class, metadata);
    }

}

