package com.danny.quizworld.course.subject.member;

import com.danny.quizworld.course.subject.Subject;
import com.danny.quizworld.course.subject.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SubjectMemberStore {
    private final SubjectMemberRepository subjectMemberRepository;

    public void save(SubjectMember subjectMember) {
        subjectMemberRepository.save(subjectMember);
    }

    public void delete(SubjectMember subjectMember) {
        subjectMemberRepository.delete(subjectMember);
    }
}
