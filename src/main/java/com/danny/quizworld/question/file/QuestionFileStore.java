package com.danny.quizworld.question.file;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class QuestionFileStore {
    private final QuestionFileRepository questionFileRepository;

    public void save(QuestionFile questionFile) {
        questionFileRepository.save(questionFile);
    }
}
