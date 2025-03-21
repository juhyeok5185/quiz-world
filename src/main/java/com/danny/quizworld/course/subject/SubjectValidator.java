package com.danny.quizworld.course.subject;

import com.danny.quizworld.common.config.MyException;
import com.danny.quizworld.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SubjectValidator {

    public void validateToSave(Member member, SubjectCommand.save request) {
        if (request.getPrice() != 0 && !member.getBusinessYn()) {
            throw new MyException("사업자 계정이 아닙니다.");
        }
    }


    public void validateToUpdate(Subject subject , SubjectCommand.update request) {
        if (subject.getDownloadId() != null){
            if(request.getPublicYn()){
                throw new MyException("다운받은 컨텐츠는 공개 할 수 없습니다.");
            }
            if(request.getPrice() != 0){
                throw new MyException("다운받은 컨텐츠는 수익화 할 수 없습니다.");
            }
        }
    }
}
