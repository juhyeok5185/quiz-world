package com.danny.quizworld.course.chapter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ChapterStore {

    private final ChapterRepository chapterRepository;

    public Chapter save(Chapter chapter) {
        return chapterRepository.save(chapter);
    }

    public void deleteAll(List<Chapter> chapterList) {
        chapterRepository.deleteAll(chapterList);
    }

    public void delete(Chapter chapter) {
        chapterRepository.delete(chapter);
    }
}
