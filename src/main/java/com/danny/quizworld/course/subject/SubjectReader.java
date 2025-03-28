package com.danny.quizworld.course.subject;

import com.danny.quizworld.common.config.MyException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SubjectReader {
    private final SubjectRepository subjectRepository;

    public List<Subject> findAllByMemberId(Long memberId) {
        return subjectRepository.findAllByMember_MemberIdAndUseYnTrueOrderBySaveDtmDesc(memberId);
    }

    public Subject findById(Long subjectId) {
        return subjectRepository.findById(subjectId).orElseThrow(() -> new MyException("과목을 찾을수 없습니다."));
    }

    public List<Subject> findAllSubjectBySearch(SubjectSearch search) {
        return subjectRepository.findAllSubjectBySearch(search);
    }

}
