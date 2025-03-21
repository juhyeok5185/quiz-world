package com.danny.quizworld.course.subject.member;

import com.danny.quizworld.course.subject.Subject;
import com.danny.quizworld.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SubjectMemberService {
    private final SubjectMemberReader subjectMemberReader;
    private final SubjectMemberStore subjectMemberStore;
    private final SubjectMemberMapper subjectMemberMapper;

    @Transactional
    public void save(SubjectMember subjectMember) {
        subjectMemberStore.save(subjectMember);
    }

    @Transactional(readOnly = true)
    public SubjectMember findBySubjectIdAndMemberId(Long subjectId, Long memberId) {
        return subjectMemberReader.findBySubjectIdAndMemberId(subjectId , memberId);
    }

    public SubjectMember toEntity(Subject subject, Member member) {
        return subjectMemberMapper.toEntity(subject, member);
    }


}
