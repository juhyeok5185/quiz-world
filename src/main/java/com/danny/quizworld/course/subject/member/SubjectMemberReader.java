package com.danny.quizworld.course.subject.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SubjectMemberReader {
    private final SubjectMemberRepository subjectMemberRepository;

    public SubjectMember findBySubjectIdAndMemberId(Long subjectId, Long memberId) {
        return subjectMemberRepository.findBySubject_SubjectIdAndMember_MemberId(subjectId , memberId);
    }

    public List<SubjectMember> findByMemberId(Long memberId) {
        return subjectMemberRepository.findByMember_MemberId(memberId);
    }

    public Long countBySubjectId(Long subjectId) {
        return subjectMemberRepository.countBySubject_SubjectId(subjectId);
    }
}
