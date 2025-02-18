package com.danny.quizworld.subject.chapter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ChapterStore {

    private final ChapterRepository chapterRepository;

    public Chapter save(Chapter chapter) {
        return chapterRepository.save(chapter);
    }
}
