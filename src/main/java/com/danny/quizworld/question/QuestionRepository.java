package com.danny.quizworld.question;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findAllByChapter_ChapterIdAndUseYnTrue(Long chapterId);
}
