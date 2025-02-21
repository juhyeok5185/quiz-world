package com.danny.quizworld.subject.chapter;

import com.danny.quizworld.subject.Subject;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChapterService {

    private final ChapterMapper chapterMapper;
    private final ChapterStore chapterStore;
    private final ChapterReader chapterReader;

    @Transactional
    public Chapter save(Chapter chapter){
        return chapterStore.save(chapter);
    }

    public Chapter toEntity(Subject subject , ChapterRequest request) {
        return chapterMapper.toEntity(subject, request);
    }

    public ChapterResponse toResponse(Chapter chapter) {
        return chapterMapper.toResponse(chapter);
    }

    @Transactional(readOnly = true)
    public List<Chapter> findAllBySubjectId(Long subjectId) {
        return chapterReader.findAllBySubjectId(subjectId);
    }

    public Chapter findById(Long chapterId) {
        return chapterReader.findById(chapterId);
    }
}
