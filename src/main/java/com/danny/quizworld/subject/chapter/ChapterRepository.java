package com.danny.quizworld.subject.chapter;

import com.danny.quizworld.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChapterRepository extends JpaRepository<Chapter, Long> {
    List<Chapter> findAllBySubject_SubjectIdAndUseYnTrue(Long subjectId);
}
