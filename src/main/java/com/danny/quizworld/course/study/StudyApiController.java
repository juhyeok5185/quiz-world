package com.danny.quizworld.course.study;

import com.danny.quizworld.common.response.ApiResponse;
import com.danny.quizworld.course.CourseFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/courses/subjects/chapters")
public class StudyApiController {

    private final CourseFacade courseFacade;


    @PostMapping("/{chapterId}/studies")
    public ResponseEntity<ApiResponse<StudyResponse>> saveStudy(@PathVariable Long chapterId, @ModelAttribute @Valid StudyCommand.save request) {
        courseFacade.saveStudy(chapterId, request);
        return ResponseEntity.status(201).body(new ApiResponse<>("생성 성공", 201, null));
    }

    @GetMapping("/{chapterId}/studies")
    public ResponseEntity<ApiResponse<List<StudyResponse>>> findAllStudyByChapterId(@PathVariable Long chapterId) {
        return ResponseEntity.ok(new ApiResponse<>(courseFacade.findAllStudyByChapterId(chapterId)));
    }

    @GetMapping("/studies/{studyId}")
    public ResponseEntity<ApiResponse<StudyResponse>> findStudyById(@PathVariable Long studyId) {
        return ResponseEntity.ok(new ApiResponse<>(courseFacade.findStudyById(studyId)));
    }

    @PatchMapping("/studies/{studyId}")
    public ResponseEntity<ApiResponse<StudyResponse>> updateStudy(@PathVariable Long studyId , @ModelAttribute @Valid StudyCommand.update request){
        courseFacade.updateStudy(studyId , request);
        return ResponseEntity.ok(new ApiResponse<>("변경 성공", 201, null));
    }

    @DeleteMapping("/studies/{studyId}")
    public ResponseEntity<ApiResponse<StudyResponse>> deleteStudyById(@PathVariable Long studyId) {
        courseFacade.deleteStudyById(studyId);
        return ResponseEntity.status(201).body(new ApiResponse<>("삭제 완료" , 201 ,null));
    }

}
