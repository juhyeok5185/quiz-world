package com.danny.quizworld.quiz.file;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class QuestionFileReader {
    private final QuestionFileRepository questionFileRepository;
}
