package com.danny.quizworld.course.chapter;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChapterRepository extends JpaRepository<Chapter, Long> {
    List<Chapter> findAllBySubject_SubjectIdOrderBySaveDtmDesc(Long subjectId);
}
