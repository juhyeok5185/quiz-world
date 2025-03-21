package com.danny.quizworld.course.study;

import com.danny.quizworld.common.config.MyException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class StudyReader {
    private final StudyRepository studyRepository;

    public List<Study> findAllByChapterId(Long chapterId) {
        return studyRepository.findAllByChapter_ChapterId(chapterId);
    }

    public Study findById(Long studyId) {
        return studyRepository.findById(studyId).orElseThrow(() -> new MyException("학습을 찾을 수 없습니다."));
    }

    public Long countBySubjectId(Long subjectId) {
        return studyRepository.countBySubject_SubjectId(subjectId);
    }

    public Long countByChapterId(Long chapterId) {
        return studyRepository.countByChapter_ChapterId(chapterId);
    }

    public List<Study> findAllBySubjectId(Long subjectId) {
        return studyRepository.findAllBySubject_SubjectId(subjectId);
    }
}
