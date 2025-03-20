package com.danny.quizworld.course.study;

import com.danny.quizworld.course.chapter.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudyRepository extends JpaRepository<Study, Long> {

    List<Study> findAllByChapter_ChapterId(Long chapterId);

}
