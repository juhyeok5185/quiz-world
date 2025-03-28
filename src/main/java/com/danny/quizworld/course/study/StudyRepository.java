package com.danny.quizworld.course.study;

import com.danny.quizworld.course.chapter.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudyRepository extends JpaRepository<Study, Long> {

    List<Study> findAllByChapter_ChapterIdOrderBySaveDtmDesc(Long chapterId);

    Long countBySubject_SubjectId(Long subjectId);

    Long countByChapter_ChapterId(Long chapterId);

    List<Study> findAllBySubject_SubjectId(Long subjectId);
}
