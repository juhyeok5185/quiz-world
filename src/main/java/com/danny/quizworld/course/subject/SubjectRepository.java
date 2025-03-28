package com.danny.quizworld.course.subject;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Long> , SubjectRepositoryCustom{
    List<Subject> findAllByMember_MemberIdAndUseYnTrueOrderBySaveDtmDesc(Long memberId);

}
