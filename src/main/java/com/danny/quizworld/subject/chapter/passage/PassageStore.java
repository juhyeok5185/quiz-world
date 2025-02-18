package com.danny.quizworld.subject.chapter.passage;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PassageStore {

    private final PassageRepository passageRepository;

    public Passage save(Passage passage) {
        return passageRepository.save(passage);
    }
}
