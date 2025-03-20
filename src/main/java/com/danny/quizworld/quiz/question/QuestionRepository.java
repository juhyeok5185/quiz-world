package com.danny.quizworld.quiz.question;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findAllByChapter_ChapterIdAndUseYnTrue(Long chapterId);

    Long countByChapter_ChapterIdAndUseYnTrue(Long chapterId);

    Long countBySubject_SubjectIdAndUseYnTrue(Long subjectId);
}
