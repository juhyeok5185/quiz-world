package com.danny.quizworld.course.subject.member;

import com.danny.quizworld.course.subject.Subject;
import com.danny.quizworld.course.subject.SubjectRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectMemberRepository extends JpaRepository<SubjectMember, Long>{

    SubjectMember findBySubject_SubjectIdAndMember_MemberId(Long subjectId, Long memberId);

    List<SubjectMember> findByMember_MemberId(Long memberId);

    Long countBySubject_SubjectId(Long subjectId);
}
