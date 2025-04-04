package com.danny.quizworld.course.subject;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SubjectStore {
    private final SubjectRepository subjectRepository;

    public Subject save(Subject subject) {
        return subjectRepository.save(subject);
    }

    public void delete(Subject subject) {
        subjectRepository.delete(subject);
    }

    public void deleteAll(List<Subject> subjectList) {
        subjectRepository.deleteAll(subjectList);
    }
}
