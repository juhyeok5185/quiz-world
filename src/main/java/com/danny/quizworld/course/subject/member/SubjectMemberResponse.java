package com.danny.quizworld.course.subject.member;

import com.danny.quizworld.course.subject.SubjectResponse;
import com.danny.quizworld.member.MemberResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SubjectMemberResponse {
    private MemberResponse member;
    private SubjectResponse subject;
}
