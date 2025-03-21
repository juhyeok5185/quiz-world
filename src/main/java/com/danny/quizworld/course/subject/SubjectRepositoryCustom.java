package com.danny.quizworld.course.subject;

import java.util.List;

public interface SubjectRepositoryCustom {
    List<Subject> findAllSubjectBySearch(SubjectSearch search);
}
