package com.danny.quizworld.course.subject;

import com.danny.quizworld.course.subject.category.Category;
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
    private final SubjectValidator subjectValidator;

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

    @Transactional
    public void deleteAll(List<Subject> subjectList) {
        subjectStore.deleteAll(subjectList);
    }

    public Subject toEntity(Member member, Category category, SubjectCommand.save request) {
        return subjectMapper.toEntity(member,category, request);
    }

    public SubjectResponse toResponse(Subject subject) {
        return subjectMapper.toResponse(subject);
    }

    public void validateToSave(Member member,SubjectCommand.save request) {
        subjectValidator.validateToSave(member , request);
    }

    public void validateToUpdate(Subject subject , SubjectCommand.update request) {
        subjectValidator.validateToUpdate(subject ,request);
    }


}
