package com.danny.quizworld.quiz.answer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    List<Answer> findAllByQuestion_QuestionIdAndUseYnTrue(Long quizId);
}
