package com.danny.quizworld.course;

import com.danny.quizworld.common.response.ApiResponse;
import com.danny.quizworld.common.util.Utils;
import com.danny.quizworld.course.chapter.ChapterResponse;
import com.danny.quizworld.course.chapter.ChapterRequest;
import com.danny.quizworld.course.study.StudyRequest;
import com.danny.quizworld.course.study.StudyResponse;
import com.danny.quizworld.course.subject.SubjectRequest;
import com.danny.quizworld.course.subject.SubjectResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/courses/subjects")
public class CourseApiController {

    private final CourseFacade courseFacade;


    //Subject 관련 API ---------------------------------------------------------------------------------------
    @PostMapping
    public ResponseEntity<ApiResponse<SubjectResponse>> saveSubject(Authentication authentication, @RequestBody SubjectRequest request) {
        Long memberId = Utils.getMemberId(authentication);
        courseFacade.saveSubject(memberId, request);
        return ResponseEntity.status(201).body(new ApiResponse<>("생성 완료" , 201 ,null));
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

    @DeleteMapping("/{subjectId}")
    public ResponseEntity<ApiResponse<SubjectResponse>> deleteSubjectById(@PathVariable Long subjectId) {
        courseFacade.deleteSubjectById(subjectId);
        return ResponseEntity.status(201).body(new ApiResponse<>("삭제 완료" , 201 ,null));
    }



    //Chapter 관련 API ---------------------------------------------------------------------------------------
    @PostMapping("/{subjectId}/chapters")
    public ResponseEntity<ApiResponse<ChapterResponse>> saveChapter(@PathVariable Long subjectId, @RequestBody ChapterRequest request) {
        courseFacade.saveChapter(subjectId, request);
        return ResponseEntity.status(201).body(new ApiResponse<>("생성 완료" , 201 ,null));
    }

    @GetMapping("/{subjectId}/chapters")
    public ResponseEntity<ApiResponse<List<ChapterResponse>>> findAllChapterBySubjectId(@PathVariable Long subjectId) {
        return ResponseEntity.ok(new ApiResponse<>(courseFacade.findAllChapterBySubjectId(subjectId)));
    }

    @GetMapping("/chapters/{chapterId}")
    public ResponseEntity<ApiResponse<ChapterResponse>> findChapterById(@PathVariable Long chapterId) {
        return ResponseEntity.ok(new ApiResponse<>(courseFacade.findChapterById(chapterId)));
    }

    @DeleteMapping("/chapters/{chapterId}")
    public ResponseEntity<ApiResponse<ChapterResponse>> deleteChapterById(@PathVariable Long chapterId) {
        courseFacade.deleteChapterById(chapterId);
        return ResponseEntity.status(201).body(new ApiResponse<>("삭제 완료" , 201 ,null));
    }

    //Study 관련 API ---------------------------------------------------------------------------------------
    @PostMapping("/chapters/{chapterId}/study")
    public ResponseEntity<ApiResponse<StudyResponse>> saveStudy(@PathVariable Long chapterId, @ModelAttribute StudyRequest request) {
        courseFacade.saveStudy(chapterId, request);
        return ResponseEntity.status(201).body(new ApiResponse<>("생성 성공", 201, null));
    }

    @GetMapping("/chapters/{chapterId}/study")
    public ResponseEntity<ApiResponse<List<StudyResponse>>> findAllStudyByChapterId(@PathVariable Long chapterId) {
        return ResponseEntity.ok(new ApiResponse<>(courseFacade.findAllStudyByChapterId(chapterId)));
    }

    @GetMapping("/chapters/study/{studyId}")
    public ResponseEntity<ApiResponse<StudyResponse>> findStudyById(@PathVariable Long studyId) {
        return ResponseEntity.ok(new ApiResponse<>(courseFacade.findStudyById(studyId)));
    }

    @PatchMapping("/chapters/study/{studyId}")
    public ResponseEntity<ApiResponse<StudyResponse>> updateStudy(@PathVariable Long studyId , @ModelAttribute StudyRequest request){
        courseFacade.updateStudy(studyId , request);
        return ResponseEntity.ok(new ApiResponse<>("변경 성공", 201, null));
    }

    @DeleteMapping("/chapters/study/{studyId}")
    public ResponseEntity<ApiResponse<StudyResponse>> deleteStudyById(@PathVariable Long studyId) {
        courseFacade.deleteStudyById(studyId);
        return ResponseEntity.status(201).body(new ApiResponse<>("삭제 완료" , 201 ,null));
    }

}
