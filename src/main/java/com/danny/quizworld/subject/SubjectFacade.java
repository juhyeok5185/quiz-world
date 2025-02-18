package com.danny.quizworld.subject;

import com.danny.quizworld.member.Member;
import com.danny.quizworld.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectFacade {

    private final MemberService memberService;
    private final SubjectService subjectService;

    public SubjectResponse save(Long memberId, String name) {
        Member member = memberService.findById(memberId);
        Subject subject = subjectService.toEntity(member , name);
        return subjectService.toResponse(subjectService.save(subject));
    }


    public List<SubjectResponse> findAllByMemberId(Long memberId) {
        List<Subject> subjectList = subjectService.findAllByMemberId(memberId);
        return subjectList.stream()
                .map(subjectService::toResponse)
                .toList();
    }
}
