package com.danny.quizworld.course.chapter;

import com.danny.quizworld.common.config.MyException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ChapterReader {

    private final ChapterRepository chapterRepository;

    public List<Chapter> findAllBySubjectId(Long subjectId) {
        return chapterRepository.findAllBySubject_SubjectIdOrderBySaveDtmDesc(subjectId);
    }

    public Chapter findById(Long chapterId) {
        return chapterRepository.findById(chapterId).orElseThrow(() -> new MyException("챕터를 찾을수 없습니다."));
    }
}
