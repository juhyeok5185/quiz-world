package com.danny.quizworld.course.study;

import com.danny.quizworld.course.chapter.Chapter;
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

    @Transactional
    public void deleteAll(List<Study> studyList) {
        studyStore.deleteAll(studyList);
    }

    @Transactional
    public void delete(Study study) {
        studyStore.delete(study);
    }

    @Transactional(readOnly = true)
    public List<Study> findAllByChapterId(Long chapterId) {
        return studyReader.findAllByChapterId(chapterId);
    }

    @Transactional(readOnly = true)
    public Study findById(Long studyId) {
        return studyReader.findById(studyId);
    }

    @Transactional(readOnly = true)
    public Long countBySubjectId(Long subjectId) {
        return studyReader.countBySubjectId(subjectId);
    }

    @Transactional(readOnly = true)
    public Long countByChapterId(Long chapterId) {
        return studyReader.countByChapterId(chapterId);
    }

    @Transactional(readOnly = true)
    public List<Study> findAllBySubjectId(Long subjectId) {
        return studyReader.findAllBySubjectId(subjectId);
    }

    public Study toEntity(Chapter chapter, StudyCommand.save request) {
        return studyMapper.toEntity(chapter, request);
    }

    public StudyResponse toResponse(Study study) {
        return studyMapper.toResponse(study);
    }



}
