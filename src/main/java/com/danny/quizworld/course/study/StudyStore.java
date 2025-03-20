package com.danny.quizworld.course.study;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StudyStore {
    private final StudyRepository studyRepository;

    public void save(Study study) {
        studyRepository.save(study);
    }
}
