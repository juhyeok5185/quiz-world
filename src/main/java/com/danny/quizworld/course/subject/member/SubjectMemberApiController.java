package com.danny.quizworld.course.subject.member;

import com.danny.quizworld.common.response.ApiResponse;
import com.danny.quizworld.common.util.Utils;
import com.danny.quizworld.course.CourseFacade;
import com.danny.quizworld.course.subject.SubjectCommand;
import com.danny.quizworld.course.subject.SubjectResponse;
import com.danny.quizworld.course.subject.SubjectSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/courses/subjects/subject-members")
public class SubjectMemberApiController {

    private final CourseFacade courseFacade;

    @PostMapping("/{subjectId}")
    public ResponseEntity<ApiResponse<SubjectResponse>> saveSubjectMember(@PathVariable String subjectId , Authentication authentication){
        Long memberId = Utils.getMemberId(authentication);
        courseFacade.saveSubjectMember(subjectId , memberId);
        return ResponseEntity.status(201).body(new ApiResponse<>("생성 완료" , 201 ,null));
    }

}
