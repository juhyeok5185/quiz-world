package com.danny.quizworld.course.study;

import com.danny.quizworld.course.chapter.Chapter;
import com.danny.quizworld.course.subject.Subject;
import com.danny.quizworld.course.subject.SubjectRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudyService {
    private final StudyReader studyReader;
    private final StudyStore studyStore;
    private final StudyMapper studyMapper;


    @Transactional
    public void save(Study study) {
        studyStore.save(study);
    }

    @Transactional(readOnly = true)
    public List<Study> findAllByChapterId(Long chapterId) {
        return studyReader.findAllByChapterId(chapterId);
    }

    @Transactional(readOnly = true)
    public Study findById(Long studyId) {
        return studyReader.findById(studyId);
    }

    public Study toEntity(Chapter chapter , StudyRequest request) {
        return studyMapper.toEntity(chapter , request);
    }

    public StudyResponse toResponse(Study study) {
        return studyMapper.toResponse(study);
    }


}
