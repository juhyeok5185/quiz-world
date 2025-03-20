package com.danny.quizworld.quiz.passage;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PassageReader {

    private final PassageRepository passageRepository;

}
