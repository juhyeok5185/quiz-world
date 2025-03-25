package com.danny.quizworld.course.subject.member;

import com.danny.quizworld.course.subject.Subject;
import com.danny.quizworld.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectMemberService {
    private final SubjectMemberReader subjectMemberReader;
    private final SubjectMemberStore subjectMemberStore;
    private final SubjectMemberMapper subjectMemberMapper;
    private final SubjectMemberValidator subjectMemberValidator;

    @Transactional
    public void save(SubjectMember subjectMember) {
        subjectMemberStore.save(subjectMember);
    }

    @Transactional(readOnly = true)
    public SubjectMember findBySubjectIdAndMemberId(Long subjectId, Long memberId) {
        return subjectMemberReader.findBySubjectIdAndMemberId(subjectId , memberId);
    }

    @Transactional(readOnly = true)
    public List<SubjectMember> findByMemberId(Long memberId) {
        return subjectMemberReader.findByMemberId(memberId);
    }

    public SubjectMember toEntity(Subject subject, Member member) {
        return subjectMemberMapper.toEntity(subject, member);
    }

    public void validateToSave(Member member , Subject subject , SubjectMember subjectMember){
        subjectMemberValidator.validateToSave(member , subject , subjectMember);
    }

}
