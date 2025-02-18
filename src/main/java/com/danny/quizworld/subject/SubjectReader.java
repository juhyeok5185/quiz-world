package com.danny.quizworld.subject;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SubjectReader {
    private final SubjectRepository subjectRepository;

    public List<Subject> findAllByMemberId(Long memberId) {
        return subjectRepository.findAllByMember_MemberIdAndUseYnTrue(memberId);
    }
}
