package com.danny.quizworld.course.subject;

import com.danny.quizworld.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectService {

    private final SubjectMapper subjectMapper;
    private final SubjectStore subjectStore;
    private final SubjectReader subjectReader;

    @Transactional
    public Subject save(Subject subject) {
        return subjectStore.save(subject);
    }

    @Transactional
    public void delete(Subject subject) {
        subjectStore.delete(subject);
    }

    @Transactional(readOnly = true)
    public List<Subject> findAllByMemberId(Long memberId) {
        return subjectReader.findAllByMemberId(memberId);
    }

    @Transactional(readOnly = true)
    public Subject findById(Long subjectId) {
        return subjectReader.findById(subjectId);
    }

    @Transactional(readOnly = true)
    public List<Subject> findAllSubjectBySearch(SubjectSearch search) {
        return subjectReader.findAllSubjectBySearch(search);
    }

    public Subject toEntity(Member member, SubjectRequest request) {
        return subjectMapper.toEntity(member, request);
    }

    public SubjectResponse toResponse(Subject subject) {
        return subjectMapper.toResponse(subject);
    }

    public Subject copy(Subject targetSubject, Member member) {
        return subjectMapper.copy(targetSubject , member);
    }
}
