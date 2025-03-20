package com.danny.quizworld.course.subject;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
    List<Subject> findAllByMember_MemberIdAndUseYnTrue(Long memberId);
}
