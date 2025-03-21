package com.danny.quizworld.course.subject;

import com.querydsl.core.types.dsl.BooleanExpression;
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
                .where(searchCondition(search))
                .fetch();
    }

    public BooleanExpression searchCondition(SubjectSearch search) {
        return subject.name.contains(search.getName());
    }
}
