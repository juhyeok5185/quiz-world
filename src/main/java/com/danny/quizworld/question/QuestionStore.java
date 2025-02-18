package com.danny.quizworld.question;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class QuestionStore {

    private final QuestionRepository questionRepository;

    public Question save(Question question) {
        return questionRepository.save(question);
    }
}
