package com.danny.quizworld.course.subject.member;

import com.danny.quizworld.common.config.MyException;
import com.danny.quizworld.course.subject.Subject;
import com.danny.quizworld.course.subject.SubjectCommand;
import com.danny.quizworld.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class SubjectMemberValidator {

    public void validateToSave(Member member , Subject subject ,SubjectMember subjectMember) {
        if(Objects.equals(member.getMemberId(), subject.getMember().getMemberId())){
            throw new MyException("본인이 등록한 과목은 신청 할 수 없습니다.");
        }
        if(subjectMember != null){
            throw new MyException("이미 등록된 과목입니다.");
        }
    }


    public void validateToUpdate(Subject subject , SubjectCommand.update request) {

    }
}
