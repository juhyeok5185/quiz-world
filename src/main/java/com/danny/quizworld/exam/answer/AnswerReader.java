package com.danny.quizworld.exam.answer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AnswerReader {

    private final AnswerRepository answerRepository;

    public List<Answer> findAllByQuestionId(Long questionId) {
        return answerRepository.findAllByQuestion_QuestionIdAndUseYnTrue(questionId);
    }
}
