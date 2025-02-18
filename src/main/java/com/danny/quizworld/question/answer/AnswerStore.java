package com.danny.quizworld.question.answer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AnswerStore {

    private final AnswerRepository answerRepository;

    public Answer save(Answer answer) {
        return answerRepository.save(answer);
    }
}
