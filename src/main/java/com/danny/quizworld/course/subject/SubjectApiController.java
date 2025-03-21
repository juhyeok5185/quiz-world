package com.danny.quizworld.course.subject;

import com.danny.quizworld.common.response.ApiResponse;
import com.danny.quizworld.common.util.Utils;
import com.danny.quizworld.course.CourseFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/courses/subjects")
public class SubjectApiController {

    private final CourseFacade courseFacade;

    @PostMapping
    public ResponseEntity<ApiResponse<SubjectResponse>> saveSubject(Authentication authentication, @RequestBody @Valid SubjectCommand.save request) {
        Long memberId = Utils.getMemberId(authentication);
        courseFacade.saveSubject(memberId, request);
        return ResponseEntity.status(201).body(new ApiResponse<>("생성 완료" , 201 ,null));
    }

    @PostMapping("/{subjectId}/download")
    public ResponseEntity<ApiResponse<SubjectResponse>> downloadSubject(@PathVariable Long subjectId , Authentication authentication) {
        Long memberId = Utils.getMemberId(authentication);
        courseFacade.downloadSubject(subjectId , memberId);
        return ResponseEntity.status(201).body(new ApiResponse<>("생성 완료" , 201 ,null));
    }

    @GetMapping("/search")
    public ResponseEntity<ApiResponse<List<SubjectResponse>>> findAllSubjectBySearch(@ModelAttribute SubjectSearch search) {
        return ResponseEntity.ok(new ApiResponse<>(courseFacade.findAllSubjectBySearch(search)));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<SubjectResponse>>> findAllSubjectByMemberId(Authentication authentication) {
        Long memberId = Utils.getMemberId(authentication);
        return ResponseEntity.ok(new ApiResponse<>(courseFacade.findAllByMemberId(memberId)));
    }

    @GetMapping("/{subjectId}")
    public ResponseEntity<ApiResponse<SubjectResponse>> findSubjectById(@PathVariable Long subjectId) {
        return ResponseEntity.ok(new ApiResponse<>(courseFacade.findSubjectById(subjectId)));
    }

    @PatchMapping("/{subjectId}")
    public ResponseEntity<ApiResponse<SubjectResponse>> updateSubject(@PathVariable Long subjectId , @RequestBody @Valid SubjectCommand.update request){
        courseFacade.updateSubject(subjectId , request);
        return ResponseEntity.status(201).body(new ApiResponse<>("변경 완료" , 201 ,null));
    }

    @DeleteMapping("/{subjectId}")
    public ResponseEntity<ApiResponse<SubjectResponse>> deleteSubjectById(@PathVariable Long subjectId) {
        courseFacade.deleteSubjectById(subjectId);
        return ResponseEntity.status(201).body(new ApiResponse<>("삭제 완료" , 201 ,null));
    }

}
