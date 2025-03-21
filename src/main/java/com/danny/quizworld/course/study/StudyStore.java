package com.danny.quizworld.course.study;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class StudyStore {
    private final StudyRepository studyRepository;

    public void save(Study study) {
        studyRepository.save(study);
    }

    public void deleteAll(List<Study> studyList) {
        studyRepository.deleteAll(studyList);
    }

    public void delete(Study study) {
        studyRepository.delete(study);
    }
}
