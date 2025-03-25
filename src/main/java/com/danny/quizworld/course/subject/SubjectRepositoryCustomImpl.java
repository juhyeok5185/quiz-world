package com.danny.quizworld.course.subject;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import static com.danny.quizworld.course.subject.QSubject.subject;

import java.util.List;

public class SubjectRepositoryCustomImpl extends QuerydslRepositorySupport implements SubjectRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public SubjectRepositoryCustomImpl(JPAQueryFactory queryFactory) {
        super(Subject.class);
        this.queryFactory = queryFactory;
    }

    @Override
    public List<Subject> findAllSubjectBySearch(SubjectSearch search) {
        return queryFactory
                .selectFrom(subject)
                .where(searchCondition(search),
                        subject.publicYn.eq(true))
                .fetch();
    }

    public BooleanBuilder searchCondition(SubjectSearch search) {
        BooleanBuilder builder = new BooleanBuilder();

        if (search.getName() != null && !search.getName().isEmpty()) {
            builder.and(subject.name.contains(search.getName()));
        }

        if (Boolean.TRUE.equals(search.getFreeYn())) {
            builder.and(subject.price.eq(0L));
        }

        return builder;
    }
}
