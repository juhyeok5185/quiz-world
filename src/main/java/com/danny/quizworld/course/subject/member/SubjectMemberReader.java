package com.danny.quizworld.course.subject.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SubjectMemberReader {
    private final SubjectMemberRepository subjectMemberRepository;

    public SubjectMember findBySubjectIdAndMemberId(Long subjectId, Long memberId) {
        return subjectMemberRepository.findBySubject_SubjectIdAndMember_MemberId(subjectId , memberId);
    }
}
