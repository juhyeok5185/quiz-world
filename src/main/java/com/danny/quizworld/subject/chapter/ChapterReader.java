package com.danny.quizworld.subject.chapter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ChapterReader {

    private final ChapterRepository chapterRepository;

    public List<Chapter> findAllBySubjectId(Long subjectId) {
        return chapterRepository.findAllBySubject_SubjectIdAndUseYnTrue(subjectId);
    }
}
